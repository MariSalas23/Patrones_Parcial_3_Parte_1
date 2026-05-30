package com.example.notification_service.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.notification_service.infrastructure.client.dto.SmsRequest;

@FeignClient(
        name = "twilio-client",
        url = "${twilio.url}"
)
public interface TwilioFeignClient {

    @PostMapping("/notificar")
    void enviar(@RequestBody SmsRequest request);

}