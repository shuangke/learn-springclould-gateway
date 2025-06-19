package com.shuangke.springcloudgateway.filters;

import jakarta.annotation.Resource;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component
public class GlobalGatewayFilter implements GlobalFilter, Ordered {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final Set<String> allowedPaths = Set.of("/login", "/order/public");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Global Gateway Filter executed: pre-processing request");

        // check if the request path is allowed
        String path = exchange.getRequest().getURI().getPath();
        if (allowedPaths.contains(path)) {
            System.out.println("Request path is allowed: " + path);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("Global Gateway Filter executed: post-processing response");
            }));
        }

        // check if the reuest header contains token
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            System.out.println("Unauthorized request: missing or invalid token");
            return Mono.error(new RuntimeException("Unauthorized request"));
        } else {
            token = token.replace("Bearer ", "");
            // check if the token exists in Redis
            if (!stringRedisTemplate.hasKey(token)) {
                System.out.println("Unauthorized request: token not found in Redis");
                return Mono.error(new RuntimeException("Unauthorized request"));
            } else {
                System.out.println("Current user: " + stringRedisTemplate.opsForValue().get(token));
            }
        }
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("Global Gateway Filter executed: post-processing response");
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
