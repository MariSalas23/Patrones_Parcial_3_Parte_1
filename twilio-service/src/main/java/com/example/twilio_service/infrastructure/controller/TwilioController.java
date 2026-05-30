package com.example.twilio_service.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.twilio_service.application.usecase.EnviarNotificacionUseCase;

@RestController
@RequestMapping("/notificar")
public class TwilioController {

    private final EnviarNotificacionUseCase useCase;

    public TwilioController(
            EnviarNotificacionUseCase useCase) {

        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<String> notificar() {

        return ResponseEntity.ok(
                useCase.ejecutar()
        );
    }
}