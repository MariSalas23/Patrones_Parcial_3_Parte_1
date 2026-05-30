package com.example.pago_service.infrastructure.entrypoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pago_service.domain.model.Pago;
import com.example.pago_service.domain.usecase.ProcesarPagoUseCase;
import com.example.pago_service.infrastructure.entrypoints.dto.PagoRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pagar")
@RequiredArgsConstructor
public class PagoController {

    private final ProcesarPagoUseCase procesarPagoUseCase;

    @PostMapping
    public String pagar(@RequestBody PagoRequest request){

        Pago pago = Pago.builder()
                .cliente(request.getCliente())
                .telefono(request.getTelefono())
                .valor(request.getValor())
                .build();

        return procesarPagoUseCase.procesar(pago);
    }
}