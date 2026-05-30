package com.example.pago_service.domain.ports;

public interface NotificationPort {

    void notificar(String telefono, String mensaje);

}