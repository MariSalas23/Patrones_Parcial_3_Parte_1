package com.example.notification_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.notification_service.domain.ports.NotificationReadRepositoryPort;
import com.example.notification_service.domain.ports.NotificationRepositoryPort;
import com.example.notification_service.domain.ports.SmsProviderPort;
import com.example.notification_service.domain.usecase.SendNotificationUseCase;
import com.example.notification_service.domain.usecase.SyncNotificationUseCase;

@Configuration
public class BeanConfig {

    @Bean
    public SendNotificationUseCase sendNotificationUseCase(
            NotificationRepositoryPort repositoryPort,
            SmsProviderPort smsProviderPort) {

        return new SendNotificationUseCase(
                repositoryPort,
                smsProviderPort);
    }

    @Bean
    public SyncNotificationUseCase syncNotificationUseCase(
            NotificationRepositoryPort commandRepository,
            NotificationReadRepositoryPort readRepository) {

        return new SyncNotificationUseCase(
                commandRepository,
                readRepository);
    }
}