package ru.volkov.integration.endpointsext;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableIntegration
@ImportResource("classpath:integration_context.xml")
public class EndpointsextApplication implements ApplicationRunner {

    private PrinterGateway gateway;

    public EndpointsextApplication(PrinterGateway gateway) {
        this.gateway = gateway;
    }

    public static void main(String[] args) {
        SpringApplication.run(EndpointsextApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person[] payloads = {new Person("Kevin", "Bowersox"), new Person("John", "Doe")};
        for (int i = 0; i < payloads.length; i++) {
            Message<?> message = MessageBuilder.withPayload(payloads[i]).setHeader("replyChannel", "outputChannel").build();
            this.gateway.print(message);
        }
    }
}
