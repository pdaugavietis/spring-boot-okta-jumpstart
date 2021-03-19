package com.example.oktademoapp.messages;

import com.example.oktademoapp.model.Pipeline;
import com.example.oktademoapp.pipelines.PipelineRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @Autowired
    PipelineRepository respository;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public void receiveMessage(String message) {
        logger.info("Received (String) " + message);
        processMessage(message);
    }

    public void receiveMessage(byte[] message) {
        String strMessage = new String(message);
        logger.info("Received (No String) " + strMessage);
        processMessage(strMessage);
    }

    private void processMessage(String message) {
        try {
            Pipeline pipeline = new ObjectMapper().readValue(message, Pipeline.class);
            logger.info(pipeline.toString());
        } catch (JsonParseException e) {
            logger.warn("Bad JSON in message: " + message);
        } catch (JsonMappingException e) {
            logger.warn("cannot map JSON to NotificationRequest: " + message);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}