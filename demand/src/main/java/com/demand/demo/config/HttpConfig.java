package com.demand.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpConfig {

    @Value("${service.inventory.url}")
    private String inventoryUrl;

    @Value("${service.order.url}")
    private String orderUrl;

    @Bean(name = "inventoryService")
    public RestClient inventoryRestClient() {
        return RestClient.builder()
                .baseUrl(inventoryUrl)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
