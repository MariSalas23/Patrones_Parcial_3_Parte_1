package com.example.pago_service.infrastructure.service;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@Service
public class CircuitStateService {

    private final CircuitBreaker circuitBreaker;

    public CircuitStateService(
            CircuitBreakerRegistry registry) {

        this.circuitBreaker =
                registry.circuitBreaker("smsCircuit");
    }

    public String estadoActual() {

        return circuitBreaker
                .getState()
                .name();
    }
}