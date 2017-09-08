package com.hdgh0g.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Hdgh0gBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hdgh0gBackendApplication.class, args);
    }

}