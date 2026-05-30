package com.example.pago_service.domain.usecase;

import com.example.pago_service.domain.model.Pago;
import com.example.pago_service.domain.ports.NotificationPort;

public class ProcesarPagoUseCase {

    private final NotificationPort notificationPort;

    public ProcesarPagoUseCase(NotificationPort notificationPort) {
        this.notificationPort = notificationPort;
    }

    public String procesar(Pago pago){

        System.out.println("Pago procesado correctamente");

        notificationPort.notificar(
                pago.getTelefono(),
                "Pago realizado por valor de $" + pago.getValor()
        );

        return "Pago realizado";
    }
}