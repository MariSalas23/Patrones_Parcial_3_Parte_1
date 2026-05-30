package com.example.notification_service.infrastructure.persistence.mongo;

import java.util.List;
import java.util.stream.Collectors;

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
    public Notification save(Notification notification) {

        NotificationDocument document =
                new NotificationDocument();

        document.setTelefono(
                notification.getTelefono());

        document.setMensaje(
                notification.getMensaje());

        document.setEstado(
                notification.getEstado());

        NotificationDocument saved =
                repository.save(document);

        System.out.println(
                "Mongo guardó notificación: "
                        + saved.getTelefono());

        return notification;
    }

    @Override
    public List<Notification> findAll() {

        return repository.findAll()
                .stream()
                .map(doc ->
                        new Notification(
                                null,
                                doc.getTelefono(),
                                doc.getMensaje(),
                                doc.getEstado()
                        ))
                .collect(Collectors.toList());
    }
}