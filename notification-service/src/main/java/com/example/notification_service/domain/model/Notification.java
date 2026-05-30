package com.example.notification_service.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private Long id;
    private String telefono;
    private String mensaje;
    private String estado;

}