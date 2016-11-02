package com.ksimeo.ya.tutorial.models;

import javax.persistence.*;

/**
 * @author Ksimeo. Created on 01.11.2016 at 19:36 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String country;

    public Director() {
    }

    public Director(String name, String surname, String country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
