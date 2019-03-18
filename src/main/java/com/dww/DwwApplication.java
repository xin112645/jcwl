package com.dww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableJms
public class DwwApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwwApplication.class, args);
    }
}
