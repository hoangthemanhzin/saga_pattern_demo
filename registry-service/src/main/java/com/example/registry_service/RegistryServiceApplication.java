package com.example.registry_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
public class RegistryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(RegistryServiceApplication.class, args);
  }

}
