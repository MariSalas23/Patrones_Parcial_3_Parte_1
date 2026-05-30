package com.example.pago_service.domain.ports;

import com.example.pago_service.domain.model.Pago;

public interface PagoRepositoryPort {

    Pago guardar(Pago pago);

}