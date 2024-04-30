package com.ram.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced   //Will add "Client side LoadBalancing" capabilities to the WebClient Builder
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }


}
