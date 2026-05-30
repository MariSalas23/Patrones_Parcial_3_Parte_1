package com.example.aldeamo_service.infrastructure.controller;

import com.example.aldeamo_service.application.usecase.EnviarNotificacionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificar")
public class AldeamoController {

    private final EnviarNotificacionUseCase useCase;

    public AldeamoController(
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