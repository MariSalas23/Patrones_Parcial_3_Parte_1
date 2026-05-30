package com.example.notification_service.domain.ports;

import com.example.notification_service.domain.model.Notification;

public interface NotificationReadRepositoryPort {

    void save(Notification notification);

}