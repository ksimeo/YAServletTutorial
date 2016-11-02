package com.ksimeo.ya.tutorial.dto;

/**
 * @author Ksimeo. Created on 01.11.2016 at 19:45 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
public class UserDTO {
    public String login;
    public String password;
    public String name;
    public String surname;

    public UserDTO() {
    }

    public String getLogin() {
        return login;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
