package com.example.notification_service.domain.ports;

import com.example.notification_service.domain.model.Notification;

import java.util.List;

public interface NotificationRepositoryPort {

    Notification save(Notification notification);

    List<Notification> findAll();

}