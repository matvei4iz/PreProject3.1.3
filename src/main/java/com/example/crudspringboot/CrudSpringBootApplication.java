package com.example.crudspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CrudSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringBootApplication.class, args);
    }

}
