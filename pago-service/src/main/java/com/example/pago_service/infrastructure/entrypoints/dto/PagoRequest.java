package com.example.pago_service.infrastructure.entrypoints.dto;

import lombok.Data;

@Data
public class PagoRequest {

    private String cliente;
    private String telefono;
    private Double valor;

}