package com.example.notification_service.infrastructure.persistence.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNotificationRepository
        extends JpaRepository<NotificationEntity, Long> {
}