package com.example.notification_service.infrastructure.persistence.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoNotificationRepository
        extends MongoRepository<NotificationDocument, String> {
}