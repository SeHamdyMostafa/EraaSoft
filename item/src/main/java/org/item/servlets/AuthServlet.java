package org.item.servlets;

import org.item.models.UserModel;
import org.item.repo.RememberMeRepo;
import org.item.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class AuthServlet extends HttpServlet {

    UserService service = new UserService();
    RememberMeRepo rememberMeRepo = new RememberMeRepo();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if ("logout".equals(action)) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                int userId = (int) session.getAttribute("userId");
                session.invalidate();
                rememberMeRepo.deleteByUserId(userId);
            }
            Cookie cookie = new Cookie("remember_token", "");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            resp.addCookie(cookie);

            resp.sendRedirect("auth?action=login");
            return;
        }

        if ("register".equals(action)) {
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String action = req.getParameter("action");

        if ("register".equals(action)) {

            UserModel user = new UserModel();
            user.setUsername(req.getParameter("username"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));

            List<String> errors = service.register(user);

            if (!errors.isEmpty()) {
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                return;
            }
            resp.sendRedirect("auth?action=login");
            return;
        }

        if ("login".equals(action)) {

            String email = req.getParameter("email");
            String password = req.getParameter("password");

            List<String> errors = service.login(email, password);
            if (!errors.isEmpty()) {
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                return;
            }

            UserModel user = service.getUser(email, password);
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());

            String token = UUID.randomUUID().toString();
            rememberMeRepo.saveToken(user.getId(), token, 7);

            Cookie cookie = new Cookie("remember_token", token);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setPath("/");
            resp.addCookie(cookie);
            resp.sendRedirect("items");
            return;
        }

        resp.sendRedirect("auth");

    }
}