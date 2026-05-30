package com.example.pago_service.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pago_service.infrastructure.client.dto.NotificationRequest;

@FeignClient(
        name = "notification-service",
        url = "${notification.url}"
)
public interface NotificationFeignClient {

    @PostMapping("/notificar")
    void enviarNotificacion(
            @RequestBody NotificationRequest request);

}