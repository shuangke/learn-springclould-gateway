package com.shuangke.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order")
    public String order() {
        return "Order Service is running!";
    }

    @GetMapping("/order/public")
    public String orderPublic() {
        return "Order Service is running, this method is free from authorization!";
    }
}
