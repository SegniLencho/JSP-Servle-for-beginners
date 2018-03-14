package com.domain;

public class Person {
    private String key;
    private String firstName;
    private String lastName;

    public Person(String key, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.key=key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
