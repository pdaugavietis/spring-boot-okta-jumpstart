package com.example.oktademoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableMongoRepositories
//@KubernetesApplication(
//		name = "okta-demo",
//		expose = true,
//		imagePullPolicy = ImagePullPolicy.Always,
//		ports = {
//				@Port(name="http", containerPort = 8080)
//		}
//)
public class OktaDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OktaDemoAppApplication.class, args);
    }

    @GetMapping("/")
    String hello(@AuthenticationPrincipal OidcUser user) {
        return String.format("Welcome, %s", user.getFullName());
    }

}
