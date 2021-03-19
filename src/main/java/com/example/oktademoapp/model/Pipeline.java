package com.example.oktademoapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pipelines")
public class Pipeline {

    @Id
    String _id;

    String name;

    @DBRef
    PlanningLocation planningLocation;

    @DBRef
    SCMLocation scmLocation;

    @DBRef
    BuilderLocation builderLocation;

    @DBRef
    ArtifactLocation artifactLocation;

}
