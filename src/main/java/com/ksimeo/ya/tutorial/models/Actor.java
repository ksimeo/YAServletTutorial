package com.ksimeo.ya.tutorial.models;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Ksimeo. Created on 01.11.2016 at 19:32 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private LocalDate yearOfBirth;
    @Column
    private String country;

    public Actor() {
    }

    public Actor(String name, String surname, LocalDate yearOfBirth, String country) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
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

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
