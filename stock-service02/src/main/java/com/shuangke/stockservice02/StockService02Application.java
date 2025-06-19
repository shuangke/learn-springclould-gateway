package com.shuangke.stockservice02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StockService02Application {

    public static void main(String[] args) {
        SpringApplication.run(StockService02Application.class, args);
    }

}
