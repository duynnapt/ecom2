package com.ecom;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class EcomConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcomConfigApplication.class, args);
    }
}
