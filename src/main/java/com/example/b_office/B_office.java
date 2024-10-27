package com.example.b_office;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class B_office {

    public static void main(String[] args) {
        SpringApplication.run(B_office.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Application is running...");
            // Keep the application alive
            Thread.currentThread().join();
        };
    }
}
