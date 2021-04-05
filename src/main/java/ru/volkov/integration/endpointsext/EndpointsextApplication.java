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

    private EnhancedPrinterGateway gateway;

    public EndpointsextApplication(EnhancedPrinterGateway gateway) {
        this.gateway = gateway;
    }

    public static void main(String[] args) {
        SpringApplication.run(EndpointsextApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person[] payloads = {new Person("Kevin", "Bowersox"), new Person("John", "Doe")};
        for (int i = 0; i < payloads.length; i++) {
            String messageString = this.gateway.uppercase(payloads[i]);
            System.out.println(messageString);
        }
    }
}
