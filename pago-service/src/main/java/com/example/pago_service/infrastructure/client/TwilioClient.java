package com.example.pago_service.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "twilio",
        url = "${twilio.url}"
)
public interface TwilioClient {

    @PostMapping("/notificar")
    String notificar();

}