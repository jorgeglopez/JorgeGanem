package com.personalsoft.docker.docker.model;

import javax.persistence.*;

@Entity
public class Person {
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPerson")
    private int idPerson;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
}
