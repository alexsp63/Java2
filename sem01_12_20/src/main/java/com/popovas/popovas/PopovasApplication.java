package com.popovas.popovas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PopovasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PopovasApplication.class, args);
    }

}
