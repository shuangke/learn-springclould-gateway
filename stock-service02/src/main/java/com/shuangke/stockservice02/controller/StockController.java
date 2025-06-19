package com.shuangke.stockservice02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    @GetMapping("/stock")
    public String getStock() {
        return "Stock Service 02 is running!";
    }
}
