package com.example.notification_service.infrastructure.entrypoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.domain.model.Notification;
import com.example.notification_service.domain.usecase.SendNotificationUseCase;
import com.example.notification_service.domain.usecase.SyncNotificationUseCase;
import com.example.notification_service.infrastructure.entrypoints.dto.NotificationRequest;

@RestController
@RequestMapping("/notificar")
public class NotificationController {

    private final SendNotificationUseCase sendUseCase;

    private final SyncNotificationUseCase syncUseCase;

    public NotificationController(
            SendNotificationUseCase sendUseCase,
            SyncNotificationUseCase syncUseCase) {

        this.sendUseCase = sendUseCase;
        this.syncUseCase = syncUseCase;
    }

    @PostMapping
    public String enviar(
            @RequestBody NotificationRequest request) {

        Notification notification =
                new Notification();

        notification.setTelefono(
                request.getTelefono());

        notification.setMensaje(
                request.getMensaje());

        sendUseCase.execute(notification);

        return "Notificación procesada";
    }

    @PostMapping("/sync")
    public String sincronizar() {

        syncUseCase.sync();

        return "Sincronización ejecutada";
    }
}