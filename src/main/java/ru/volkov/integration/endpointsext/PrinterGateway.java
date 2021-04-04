package ru.volkov.integration.endpointsext;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
