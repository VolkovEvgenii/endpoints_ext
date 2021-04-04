package ru.volkov.integration.endpointsext;

public class UppercaseService {

    public void execute(Person person) {
        System.out.println((person.getFirstName() + " " + person.getLastName()).toUpperCase());
    }
}
