package com.example.oktademoapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SCMLocation {

    @Id
    String _id;

    String url;
    String username;
    String password;
    String sshKey;

}
