package com.example.notification_service.infrastructure.entrypoints.dto;

public class NotificationRequest {

    private String telefono;
    private String mensaje;

    public NotificationRequest() {
    }

    public NotificationRequest(String telefono,
                               String mensaje) {
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}