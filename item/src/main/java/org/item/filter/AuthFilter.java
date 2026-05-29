package org.item.filter;

import org.item.models.UserModel;
import org.item.repo.RememberMeRepo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    RememberMeRepo repo = new RememberMeRepo();
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        if (uri.contains("/auth")
                || uri.endsWith("login.jsp")
                || uri.endsWith("register.jsp")) {

            chain.doFilter(request, response);
            return;
        }


        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            chain.doFilter(request, response);
            return;
        }

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("remember_token".equals(c.getName())) {
                    UserModel user = repo.findUserByToken(c.getValue());
                    if (user != null) {
                        HttpSession newSession = req.getSession();
                        newSession.setAttribute("userId", user.getId());
                        chain.doFilter(request, response);
                        return;
                    }
                }
            }
        }

        resp.sendRedirect("login.jsp");
    }
}