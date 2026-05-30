package com.example.aldeamo_service.application.service;

import com.example.aldeamo_service.application.usecase.EnviarNotificacionUseCase;
import com.example.aldeamo_service.infrastructure.persistence.entity.NotificacionEntity;
import com.example.aldeamo_service.infrastructure.persistence.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnviarNotificacionService
        implements EnviarNotificacionUseCase {

    private final NotificacionRepository repository;

    public EnviarNotificacionService(
            NotificacionRepository repository) {

        this.repository = repository;
    }

    @Override
    public String ejecutar() {

        NotificacionEntity entity =
                new NotificacionEntity();

        entity.setProveedor("ALDEAMO");
        entity.setMensaje("SMS enviado");
        entity.setFecha(LocalDateTime.now());

        repository.save(entity);

        return "SMS enviado por Aldeamo";
    }
}