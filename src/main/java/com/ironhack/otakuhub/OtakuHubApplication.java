package com.ironhack.otakuhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OtakuHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtakuHubApplication.class, args);
    }

}
