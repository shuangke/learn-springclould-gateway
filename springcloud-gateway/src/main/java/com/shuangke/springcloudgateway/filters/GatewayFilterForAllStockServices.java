package com.shuangke.springcloudgateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GatewayFilterForAllStockServices extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        log.info("GatewayFilterForAllStockServices Filter executed: pre-processing");
        return (exchange, chain) -> {
            log.info("GatewayFilterForAllStockServices Filter executed: post-processing");
            return chain.filter(exchange);
        };
    }
}
