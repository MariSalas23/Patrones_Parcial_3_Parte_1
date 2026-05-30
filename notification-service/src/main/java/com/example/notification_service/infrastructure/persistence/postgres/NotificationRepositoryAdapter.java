package com.example.notification_service.infrastructure.persistence.postgres;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.notification_service.domain.model.Notification;
import com.example.notification_service.domain.ports.NotificationRepositoryPort;

@Component
public class NotificationRepositoryAdapter
        implements NotificationRepositoryPort {

    private final JpaNotificationRepository repository;

    public NotificationRepositoryAdapter(
            JpaNotificationRepository repository) {

        this.repository = repository;
    }

    @Override
    public Notification save(Notification notification) {

        NotificationEntity entity =
                new NotificationEntity();

        entity.setTelefono(notification.getTelefono());
        entity.setMensaje(notification.getMensaje());
        entity.setEstado(notification.getEstado());

        NotificationEntity saved =
                repository.save(entity);

        return new Notification(
                saved.getId(),
                saved.getTelefono(),
                saved.getMensaje(),
                saved.getEstado()
        );
    }

    @Override
    public List<Notification> findAll() {

        return repository.findAll()
                .stream()
                .map(entity ->
                        new Notification(
                                entity.getId(),
                                entity.getTelefono(),
                                entity.getMensaje(),
                                entity.getEstado()
                        ))
                .collect(Collectors.toList());
    }
}