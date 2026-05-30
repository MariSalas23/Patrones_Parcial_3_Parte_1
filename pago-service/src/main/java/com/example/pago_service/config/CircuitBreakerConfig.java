package com.example.pago_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@Configuration
public class CircuitBreakerConfig {

    @Bean
    public Object circuitBreakerEvents(
            CircuitBreakerRegistry registry) {

        registry.circuitBreaker("smsCircuit")
                .getEventPublisher()

                .onStateTransition(event ->

                        System.out.println(
                                "\n=====================================\n" +
                                "CAMBIO DE ESTADO DEL CIRCUITO\n" +
                                event.getStateTransition() +
                                "\n=====================================\n"
                        )
                );

        return new Object();
    }
}