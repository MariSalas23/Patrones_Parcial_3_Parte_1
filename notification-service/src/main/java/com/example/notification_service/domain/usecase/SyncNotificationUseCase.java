package com.example.notification_service.domain.usecase;

import com.example.notification_service.domain.model.Notification;
import com.example.notification_service.domain.ports.NotificationReadRepositoryPort;
import com.example.notification_service.domain.ports.NotificationRepositoryPort;

import java.util.List;

public class SyncNotificationUseCase {

    private final NotificationRepositoryPort commandRepository;

    private final NotificationReadRepositoryPort readRepository;

    public SyncNotificationUseCase(
            NotificationRepositoryPort commandRepository,
            NotificationReadRepositoryPort readRepository) {

        this.commandRepository = commandRepository;
        this.readRepository = readRepository;
    }

    public void sync() {

        List<Notification> notifications =
                commandRepository.findAll();

        notifications.forEach(readRepository::save);

        System.out.println(
                "Sincronización SQL -> Mongo completada");
    }
}