package ru.volkov.integration.endpointsext;

public class UppercaseService {

    public String execute(Person person) {
        return (person.getFirstName() + " " + person.getLastName()).toUpperCase();
    }
}
