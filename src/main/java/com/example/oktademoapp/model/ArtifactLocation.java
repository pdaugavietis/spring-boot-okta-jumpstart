package com.example.oktademoapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ArtifactLocation {
    @Id
    String _id;

    String type;
    String name;
    String url;
}
