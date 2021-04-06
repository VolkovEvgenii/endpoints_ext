package ru.volkov.integration.endpointsext;

public class PersonDirectoryService {

    public Person findNewPerson() {
        System.out.println("Inbound adapter has polled this service");
        return new Person("Jane", "Doe");
    }
}
