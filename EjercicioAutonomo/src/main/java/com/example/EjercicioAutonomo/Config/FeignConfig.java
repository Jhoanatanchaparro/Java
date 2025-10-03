package com.example.EjercicioAutonomo.Config;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class FeignConfig {

    @Value("${api.token}")
    private String apiToken;

    @Bean
    public Request.Options options() {
        return new Request.Options(
                Duration.ofMillis(2000),
                Duration.ofMillis(3000),
                true
        );
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor bearerAuthRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + apiToken);
            requestTemplate.header("Content-Type", "application/json");
        };
    }
}
