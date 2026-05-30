package com.example.notification_service.infrastructure.persistence.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notifications_read")
public class NotificationDocument {

    @Id
    private String id;

    private Long notificationId;

    private String telefono;

    private String mensaje;

    private String estado;

    public NotificationDocument() {
    }

    public NotificationDocument(String id,
                                Long notificationId,
                                String telefono,
                                String mensaje,
                                String estado) {
        this.id = id;
        this.notificationId = notificationId;
        this.telefono = telefono;
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}