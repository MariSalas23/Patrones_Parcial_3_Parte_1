package com.example.notification_service.domain.ports;

import java.util.List;

import com.example.notification_service.domain.model.Notification;

public interface NotificationReadRepositoryPort {

    Notification save(Notification notification);

    List<Notification> findAll();

}