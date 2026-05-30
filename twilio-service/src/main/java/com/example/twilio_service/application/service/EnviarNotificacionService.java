package com.example.twilio_service.application.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.twilio_service.application.usecase.EnviarNotificacionUseCase;
import com.example.twilio_service.infrastructure.persistence.entity.NotificacionEntity;
import com.example.twilio_service.infrastructure.persistence.repository.NotificacionRepository;

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

        entity.setProveedor("TWILIO");
        entity.setMensaje("SMS enviado");
        entity.setFecha(LocalDateTime.now());

        repository.save(entity);

        return "SMS enviado por Twilio";
    }
}