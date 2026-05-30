package com.example.pago_service.infrastructure.adapter;

import org.springframework.stereotype.Component;

import com.example.pago_service.domain.ports.NotificacionPort;
import com.example.pago_service.infrastructure.client.AldeamoClient;
import com.example.pago_service.infrastructure.client.TwilioClient;
import com.example.pago_service.infrastructure.service.CircuitStateService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class NotificacionAdapter
        implements NotificacionPort {

    private final AldeamoClient aldeamoClient;
    private final TwilioClient twilioClient;
    private final CircuitStateService stateService;

    public NotificacionAdapter(
            AldeamoClient aldeamoClient,
            TwilioClient twilioClient,
            CircuitStateService stateService) {

        this.aldeamoClient = aldeamoClient;
        this.twilioClient = twilioClient;
        this.stateService = stateService;
    }

    @Override
    @CircuitBreaker(
            name = "smsCircuit",
            fallbackMethod = "fallbackTwilio"
    )
    public String enviarNotificacion() {

        String estado =
                stateService.estadoActual();

        System.out.println(
                "Circuito " + estado +
                " -> usando ALDEAMO"
        );

        return """
                Estado circuito: %s
                Proveedor: ALDEAMO
                %s
                """
                .formatted(
                        estado,
                        aldeamoClient.notificar()
                );
    }

    public String fallbackTwilio(
        Exception ex) {

    String estado =
            stateService.estadoActual();

    if (!"OPEN".equals(estado)) {

        System.out.println(
                "Circuito CLOSED -> ALDEAMO FALLÓ"
        );

        throw new RuntimeException(
                """
                ALDEAMO NO DISPONIBLE

                Estado circuito: CLOSED

                Vuelva a intentar.
                """
        );
    }

    System.out.println(
            "Circuito OPEN -> usando TWILIO"
    );

    return """
            Estado circuito: OPEN
            Proveedor: TWILIO

            %s
            """
            .formatted(
                    twilioClient.notificar()
            );
    }
}