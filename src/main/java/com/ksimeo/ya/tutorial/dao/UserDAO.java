package com.ksimeo.ya.tutorial.dao;

import com.ksimeo.ya.tutorial.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Ksimeo. Created on 01.11.2016 at 20:08 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserDAO extends CrudRepository<User, Integer> {

    @Query(value="select * from users where login=:login", nativeQuery=true)
    public User findByLogin(@Param("login")String login);
}