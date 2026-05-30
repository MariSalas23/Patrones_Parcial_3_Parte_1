package com.example.pago_service.infrastructure.persistence.repository;

import com.example.pago_service.infrastructure.persistence.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPagoRepository
        extends JpaRepository<PagoEntity, Long> {
}