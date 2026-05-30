package com.example.pago_service.infrastructure.adapters;

import com.example.pago_service.domain.ports.NotificationPort;
import com.example.pago_service.infrastructure.client.NotificationFeignClient;
import com.example.pago_service.infrastructure.client.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationAdapter implements NotificationPort {

    private final NotificationFeignClient client;

    @Override
    public void notificar(String telefono, String mensaje) {

        NotificationRequest request =
                new NotificationRequest(
                        telefono,
                        mensaje
                );

        client.enviarNotificacion(request);

        System.out.println("Notification Service llamado");
    }
}