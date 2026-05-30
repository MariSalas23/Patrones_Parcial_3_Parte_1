package com.example.notification_service.infrastructure.adapters;

import org.springframework.stereotype.Component;

import com.example.notification_service.domain.model.Notification;
import com.example.notification_service.domain.ports.SmsProviderPort;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class SmsProviderAdapter
        implements SmsProviderPort {

    private final AldeamoAdapter aldeamoAdapter;

    private final TwilioAdapter twilioAdapter;

    public SmsProviderAdapter(
            AldeamoAdapter aldeamoAdapter,
            TwilioAdapter twilioAdapter) {

        this.aldeamoAdapter = aldeamoAdapter;
        this.twilioAdapter = twilioAdapter;
    }

    @Override
    @CircuitBreaker(
            name = "aldeamoCB",
            fallbackMethod = "fallbackToTwilio"
    )
    public void send(Notification notification) {

        aldeamoAdapter.send(notification);

        System.out.println(
                "Circuit CLOSED - Aldeamo");
    }

    public void fallbackToTwilio(
            Notification notification,
            Exception ex) {

        System.out.println(
                "Circuit OPEN - Twilio");

        twilioAdapter.send(notification);
    }
}