package com.example.pago_service.infrastructure.persistence.adapter;

import com.example.pago_service.domain.model.Pago;
import com.example.pago_service.domain.ports.PagoRepositoryPort;
import com.example.pago_service.infrastructure.persistence.entity.PagoEntity;
import com.example.pago_service.infrastructure.persistence.repository.SpringDataPagoRepository;
import org.springframework.stereotype.Component;

@Component
public class PagoRepositoryAdapter implements PagoRepositoryPort {

    private final SpringDataPagoRepository repository;

    public PagoRepositoryAdapter(
            SpringDataPagoRepository repository) {

        this.repository = repository;
    }

    @Override
    public Pago guardar(Pago pago) {

        PagoEntity entity = new PagoEntity();

        entity.setReferencia(
                pago.getReferencia()
        );

        entity.setFecha(
                pago.getFecha()
        );

        repository.save(entity);

        pago.setId(entity.getId());

        return pago;
    }
}