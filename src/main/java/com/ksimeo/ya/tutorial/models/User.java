package com.ksimeo.ya.tutorial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ksimeo. Created on 01.11.2016 at 18:56 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;

    public User() {
        //NOP
    }

    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}