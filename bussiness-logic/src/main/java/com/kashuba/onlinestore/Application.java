package com.kashuba.onlinestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.kashuba.onlinestore") //to scan the specified package for repositories
@EntityScan("com.kashuba.onlinestore") //to pick up our JPA entities
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // SpringApplication.run возвращает context
    }
}
