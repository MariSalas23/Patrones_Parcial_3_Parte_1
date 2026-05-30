package com.example.pago_service.config;

import com.example.pago_service.domain.ports.NotificationPort;
import com.example.pago_service.domain.usecase.ProcesarPagoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProcesarPagoUseCase procesarPagoUseCase(
            NotificationPort notificationPort
    ){
        return new ProcesarPagoUseCase(notificationPort);
    }
}