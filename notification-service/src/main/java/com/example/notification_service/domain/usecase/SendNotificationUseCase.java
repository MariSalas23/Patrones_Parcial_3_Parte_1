package com.example.notification_service.domain.usecase;

import com.example.notification_service.domain.model.Notification;
import com.example.notification_service.domain.ports.NotificationRepositoryPort;
import com.example.notification_service.domain.ports.SmsProviderPort;

public class SendNotificationUseCase {

    private final NotificationRepositoryPort repositoryPort;

    private final SmsProviderPort smsProviderPort;

    public SendNotificationUseCase(
            NotificationRepositoryPort repositoryPort,
            SmsProviderPort smsProviderPort) {

        this.repositoryPort = repositoryPort;
        this.smsProviderPort = smsProviderPort;
    }

    public void execute(Notification notification) {

        notification.setEstado("PENDIENTE");

        Notification saved =
                repositoryPort.save(notification);

        smsProviderPort.send(saved);

    }
}