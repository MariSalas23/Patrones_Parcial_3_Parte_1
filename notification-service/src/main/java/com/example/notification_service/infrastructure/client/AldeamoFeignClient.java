package com.example.notification_service.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.notification_service.infrastructure.client.dto.SmsRequest;

@FeignClient(
        name = "aldeamo-client",
        url = "${aldeamo.url}"
)
public interface AldeamoFeignClient {

    @PostMapping("/notificar")
    void enviar(@RequestBody SmsRequest request);

}