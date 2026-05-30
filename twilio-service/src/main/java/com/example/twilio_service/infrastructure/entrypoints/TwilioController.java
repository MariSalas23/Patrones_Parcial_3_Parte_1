package com.example.twilio_service.infrastructure.entrypoints;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificar")
public class TwilioController {

    @PostMapping
    public Map<String, Object> enviar(
            @RequestBody SmsRequest request) {

        System.out.println(
                "====================================");

        System.out.println(
                "TWILIO RECIBIÓ MENSAJE");

        System.out.println(
                "Teléfono: "
                        + request.getTelefono());

        System.out.println(
                "Mensaje: "
                        + request.getMensaje());

        System.out.println(
                "Fecha: "
                        + LocalDateTime.now());

        System.out.println(
                "====================================");

        return Map.of(
                "provider", "Twilio",
                "status", "OK",
                "timestamp", LocalDateTime.now()
        );
    }
}