package com.example.notification_service.infrastructure.persistence.postgres;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNotificationRepository
        extends JpaRepository<NotificationEntity, Long> {

    List<NotificationEntity> findBySincronizadoFalse();
}