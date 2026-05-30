package com.example.pago_service.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "aldeamo",
        url = "${aldeamo.url}"
)
public interface AldeamoClient {

    @PostMapping("/notificar")
    String notificar();

}