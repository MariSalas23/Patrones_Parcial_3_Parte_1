package com.example.notification_service.domain.ports;

import com.example.notification_service.domain.model.Notification;

public interface SmsProviderPort {

    void send(Notification notification);

}