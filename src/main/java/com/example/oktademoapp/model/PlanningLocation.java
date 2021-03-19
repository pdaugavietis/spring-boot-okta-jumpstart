package com.example.oktademoapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class PlanningLocation {

    @Id
    String _id;

    String type;
    String name;
    String url;

}
