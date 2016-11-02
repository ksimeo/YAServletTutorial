package com.ksimeo.ya.tutorial.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ksimeo. Created on 01.11.2016 at 20:17 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/mainmenu.do")
public class MainCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

    }
}
