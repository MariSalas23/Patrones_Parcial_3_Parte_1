package com.example.pago_service.infrastructure.controller;

import com.example.pago_service.application.usecase.ProcesarPagoUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagar")
public class PagoController {

    private final ProcesarPagoUseCase useCase;

    public PagoController(ProcesarPagoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<String> pagar() {

        return ResponseEntity.ok(
                useCase.ejecutar()
        );
    }
}