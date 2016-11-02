package com.ksimeo.ya.tutorial.services;

import com.ksimeo.ya.tutorial.dto.UserDTO;
import com.ksimeo.ya.tutorial.models.User;

import java.util.List;

/**
 * @author Ksimeo. Created on 01.11.2016 at 18:55 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

    void addUser(UserDTO userDTO);
    User getUser(int id);
    User getUser(UserDTO userDTO);
    List<User> getAllUsers();
}
