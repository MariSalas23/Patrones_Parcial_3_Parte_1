package com.example.aldeamo_service.infrastructure.persistence.repository;

import com.example.aldeamo_service.infrastructure.persistence.entity.NotificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository
        extends JpaRepository<NotificacionEntity, Long> {
}