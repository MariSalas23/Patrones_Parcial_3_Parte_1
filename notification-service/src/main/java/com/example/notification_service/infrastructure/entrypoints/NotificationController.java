package com.example.notification_service.infrastructure.entrypoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.domain.model.Notification;
import com.example.notification_service.domain.usecase.SendNotificationUseCase;
import com.example.notification_service.infrastructure.entrypoints.dto.NotificationRequest;

@RestController
@RequestMapping("/api/notificar")
public class NotificationController {

    private final SendNotificationUseCase useCase;

    public NotificationController(
            SendNotificationUseCase useCase) {

        this.useCase = useCase;
    }

    @PostMapping
    public String enviar(
            @RequestBody NotificationRequest request) {

        Notification notification = new Notification();

        notification.setTelefono(
                request.getTelefono());

        notification.setMensaje(
                request.getMensaje());

        useCase.execute(notification);

        return "Notificación procesada";
    }
}