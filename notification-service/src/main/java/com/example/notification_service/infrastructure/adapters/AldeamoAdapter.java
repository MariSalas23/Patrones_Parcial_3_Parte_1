package com.example.notification_service.infrastructure.adapters;

import org.springframework.stereotype.Component;

import com.example.notification_service.domain.model.Notification;
import com.example.notification_service.infrastructure.client.AldeamoFeignClient;
import com.example.notification_service.infrastructure.client.dto.SmsRequest;

@Component
public class AldeamoAdapter {

    private final AldeamoFeignClient client;

    public AldeamoAdapter(AldeamoFeignClient client) {
        this.client = client;
    }

    public void send(Notification notification) {

        SmsRequest request =
                new SmsRequest(
                        notification.getTelefono(),
                        notification.getMensaje()
                );

        client.enviar(request);

        System.out.println(
                "SMS enviado por Aldeamo");
    }
}