package com.ksimeo.ya.tutorial.services.impl;

import com.ksimeo.ya.tutorial.dao.UserDAO;
import com.ksimeo.ya.tutorial.dto.UserDTO;
import com.ksimeo.ya.tutorial.helpers.SecurityHelper;
import com.ksimeo.ya.tutorial.models.User;
import com.ksimeo.ya.tutorial.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 01.11.2016 at 19:44 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServImpl implements UserService {
    @Autowired
    private UserDAO usrDao;

    @Override
    public void addUser(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        usrDao.save(user);
    }

    @Override
    public User getUser(int id) {
        return usrDao.findOne(id);
    }

    @Override
    public User getUser(UserDTO userDTO) {
        String login = userDTO.getLogin();
        String password = userDTO.getPassword();
        User toSend = usrDao.findByLogin(login);
        String passw = userDTO.getPassword();
        try {
            passw = SecurityHelper.String2Hash(passw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (passw.equals(toSend.getPassword()))
        return toSend;
        else return null;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)usrDao.findAll();
    }
}
