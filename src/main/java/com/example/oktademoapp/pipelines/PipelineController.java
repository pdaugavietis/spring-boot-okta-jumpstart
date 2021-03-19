package com.example.oktademoapp.pipelines;

import com.example.oktademoapp.messages.QueueProducer;
import com.example.oktademoapp.model.Pipeline;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api/v1")
public class PipelineController {

    public PipelineController(PipelineRepository pipelineRepository) {
        this.pipelineRepository = pipelineRepository;
    }

    @Autowired
    PipelineRepository pipelineRepository;

    @Autowired
    QueueProducer producer;

    @GetMapping(value = "/pipeline", produces = "application/json")
    public List<Pipeline> getPipelines() {
        List<Pipeline> pipelines = pipelineRepository.findAll();
        for (Pipeline pipeline: pipelines) {
            log.info(pipeline.toString());
        }
        return pipelines;
    }

    @GetMapping(value = "/pipeline/{id}", produces = "application/json")
    public Optional<Pipeline> getPipeline(@PathVariable String id) {
        return pipelineRepository.findById(id);
    }

    @PostMapping("/pipeline/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<Pipeline> sendPipeline(@PathVariable String id) throws Exception {
        Optional<Pipeline> pipeline = pipelineRepository.findById(id);
        producer.produce(pipeline);
        return pipeline;
    }
}
