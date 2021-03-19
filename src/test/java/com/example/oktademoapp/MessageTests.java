package com.example.oktademoapp;

import com.example.oktademoapp.messages.QueueConsumer;
import com.example.oktademoapp.messages.QueueProducer;
import com.example.oktademoapp.model.Pipeline;
import com.example.oktademoapp.pipelines.PipelineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MessageTests {

    @Autowired
    QueueConsumer consumer;

    @Autowired
    QueueProducer producer;

    @Autowired
    PipelineRepository repository;

    @Test
    void sendMessage() {
        List<Pipeline> pipelineObjects = repository.findAll();
        try {
            producer.produce(java.util.Optional.ofNullable(pipelineObjects.get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMessage() {

    }
}
