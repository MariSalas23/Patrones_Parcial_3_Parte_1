package com.example.notification_service.infrastructure.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.notification_service.domain.usecase.SyncNotificationUseCase;

@Component
public class NotificationSyncScheduler {

    private final SyncNotificationUseCase useCase;

    public NotificationSyncScheduler(
            SyncNotificationUseCase useCase) {

        this.useCase = useCase;
    }

    @Scheduled(fixedRate = 30000)
    public void sync() {

        System.out.println(
                "Ejecutando sincronización SQL -> Mongo");

        useCase.sync();
    }
}