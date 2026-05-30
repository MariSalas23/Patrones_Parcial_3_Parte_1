package com.example.twilio_service.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.twilio_service.infrastructure.persistence.entity.NotificacionEntity;

public interface NotificacionRepository
        extends JpaRepository<NotificacionEntity, Long> {
}