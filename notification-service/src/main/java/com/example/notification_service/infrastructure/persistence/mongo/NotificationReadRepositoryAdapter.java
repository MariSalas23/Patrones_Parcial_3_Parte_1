package com.example.notification_service.infrastructure.persistence.mongo;

import org.springframework.stereotype.Component;

import com.example.notification_service.domain.model.Notification;
import com.example.notification_service.domain.ports.NotificationReadRepositoryPort;

@Component
public class NotificationReadRepositoryAdapter
        implements NotificationReadRepositoryPort {

    private final MongoNotificationRepository repository;

    public NotificationReadRepositoryAdapter(
            MongoNotificationRepository repository) {

        this.repository = repository;
    }

    @Override
    public void save(Notification notification) {

        NotificationDocument document =
                new NotificationDocument();

        document.setNotificationId(
                notification.getId());

        document.setTelefono(
                notification.getTelefono());

        document.setMensaje(
                notification.getMensaje());

        document.setEstado(
                notification.getEstado());

        repository.save(document);
    }
}