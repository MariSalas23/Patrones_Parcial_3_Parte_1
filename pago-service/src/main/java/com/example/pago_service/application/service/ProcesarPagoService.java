package com.example.pago_service.application.service;

import com.example.pago_service.application.usecase.ProcesarPagoUseCase;
import com.example.pago_service.domain.model.Pago;
import com.example.pago_service.domain.ports.NotificacionPort;
import com.example.pago_service.domain.ports.PagoRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProcesarPagoService implements ProcesarPagoUseCase {

    private final PagoRepositoryPort repository;
    private final NotificacionPort notificacionPort;

    public ProcesarPagoService(
            PagoRepositoryPort repository,
            NotificacionPort notificacionPort) {

        this.repository = repository;
        this.notificacionPort = notificacionPort;
    }

    @Override
    public String ejecutar() {

        Pago pago = new Pago();

        pago.setReferencia(UUID.randomUUID().toString());
        pago.setFecha(LocalDateTime.now());

        repository.guardar(pago);

        return notificacionPort.enviarNotificacion();
    }
}