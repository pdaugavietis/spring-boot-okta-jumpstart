package com.example.oktademoapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BuilderLocation {
    @Id
    String _id;

    String type;
    String name;
    String url;
}
