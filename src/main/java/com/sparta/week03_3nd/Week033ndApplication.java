package com.sparta.week03_3nd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week033ndApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week033ndApplication.class, args);
    }

}
