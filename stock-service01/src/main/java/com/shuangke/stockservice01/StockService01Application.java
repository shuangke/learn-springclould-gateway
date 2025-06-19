package com.shuangke.stockservice01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StockService01Application {

    public static void main(String[] args) {
        SpringApplication.run(StockService01Application.class, args);
    }

}
