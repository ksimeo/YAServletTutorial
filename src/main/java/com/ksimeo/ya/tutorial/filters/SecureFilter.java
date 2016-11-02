package com.ksimeo.ya.tutorial.filters;

import com.ksimeo.ya.tutorial.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Ksimeo. Created on 02.11.2016 at 14:11 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
@WebFilter(urlPatterns = "/*.do")
public class SecureFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        Cookie[] cookies = req.getCookies();
        boolean isLoggedIn = false;
        User sessionUserAttr = null;

        if (session != null && cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    sessionUserAttr = (User) session.getAttribute("user");
                    if (null == sessionUserAttr) break;
                    isLoggedIn = cookie.getValue().equalsIgnoreCase(sessionUserAttr.getLogin());
                    break;
                }
            }
        }

        if (!isLoggedIn && !(uri.endsWith("index.jsp")))
            resp.sendRedirect("/index.jsp");
        else if (sessionUserAttr != null) {
            if (uri.endsWith("/logout")) filterChain.doFilter(servletRequest, servletResponse);
            else if (!isLoggedIn && (uri.endsWith(".do"))) resp.sendRedirect("/index.jsp");
            else filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
