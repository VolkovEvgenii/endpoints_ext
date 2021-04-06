package ru.volkov.integration.endpointsext;

public class PersonRegistrationService {

    public void registerEmail(Person person) {
        System.out.println("Email created for: " + person.getFirstName());
    }
}
