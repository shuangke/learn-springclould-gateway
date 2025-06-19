package com.shuangke.stockservice01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @GetMapping("/stock")
    public String stock() {
        return "Stock Service 01 is running!";
    }
}

