package com.example.oktademoapp.pipelines;

import com.example.oktademoapp.model.Pipeline;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PipelineRepository extends MongoRepository<Pipeline, String> {

}
