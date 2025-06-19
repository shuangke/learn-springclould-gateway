package com.shuangke.authuserservice.controller;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AuthUserController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/login")
    public String login(@RequestParam String username) {
        UUID token = UUID.randomUUID();
        // Store the token in Redis with a 1-hour expiration
        stringRedisTemplate.opsForValue().set(token.toString(), username);
        return token.toString();
    }
}
