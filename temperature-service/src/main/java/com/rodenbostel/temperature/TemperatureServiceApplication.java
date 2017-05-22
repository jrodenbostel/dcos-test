package com.rodenbostel.temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TemperatureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemperatureServiceApplication.class, args);
    }
}
