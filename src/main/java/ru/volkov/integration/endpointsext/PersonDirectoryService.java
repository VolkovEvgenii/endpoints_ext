package ru.volkov.integration.endpointsext;

public class PersonDirectoryService {

    public Person findNewPerson() {
        return new Person("Jane", "Doe");
    }
}
