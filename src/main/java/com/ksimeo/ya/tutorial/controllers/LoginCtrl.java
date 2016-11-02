package com.ksimeo.ya.tutorial.controllers;

import com.ksimeo.ya.tutorial.dto.UserDTO;
import com.ksimeo.ya.tutorial.models.User;
import com.ksimeo.ya.tutorial.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Ksimeo. Created on 01.11.2016 at 18:30 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/login")
public class LoginCtrl extends HttpServlet {
    @Autowired
    private UserService userServ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(login);
        userDTO.setPassword(password);
        User user = userServ.getUser(userDTO);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(30*60);
            Cookie userLogin = new Cookie("user", login);
            userLogin.setMaxAge(30*60);
            resp.addCookie(userLogin);
            resp.sendRedirect("/mainmenu.do");
        } else {
            req.setAttribute("error", "Вы ввели неверный логин или/и пароль!");
            req.getRequestDispatcher("index.jsp");
        }
    }
}
