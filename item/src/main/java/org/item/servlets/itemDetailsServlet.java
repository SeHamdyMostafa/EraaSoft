package org.item.servlets;

import org.item.models.item_details;
import org.item.service.itemDetailsService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class itemDetailsServlet extends HttpServlet {

    private final itemDetailsService service = new itemDetailsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("addForm".equals(action)) {
            req.getRequestDispatcher("add-details.jsp").forward(req, resp);
            return;
        }
        if ("details".equals(action)) {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            req.setAttribute("itemId", itemId);
            req.setAttribute("details", service.getItemDetailsById(itemId));
            req.getRequestDispatcher("item-details.jsp").forward(req, resp);
            return;
        }
        if ("editForm".equals(action)) {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            req.setAttribute("itemId", itemId);
            req.setAttribute("details", service.getItemDetailsById(itemId));
            req.getRequestDispatcher("update-details.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect("items");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("add".equals(action)) {

            item_details details = new item_details();
            details.setItemId(Integer.parseInt(req.getParameter("itemId")));
            details.setDescription(req.getParameter("description"));
            details.setColor(req.getParameter("color"));
            details.setWeight(req.getParameter("weight"));

            List<String> errors = service.addItemDetails(details);
            if (!errors.isEmpty()) {
                req.setAttribute("errors", errors);
                req.setAttribute("details", details);
                req.getRequestDispatcher("add-details.jsp").forward(req, resp);
                return;
            }

            resp.sendRedirect("items");
            return;
        }

        if ("update".equals(action)) {

            int itemId = Integer.parseInt(req.getParameter("itemId"));
            item_details details = new item_details();
            details.setItemId(itemId);
            details.setDescription(req.getParameter("description"));
            details.setColor(req.getParameter("color"));
            details.setWeight(req.getParameter("weight"));

            List<String> errors = service.updateItemDetails(itemId, details);
            if (!errors.isEmpty()) {
                req.setAttribute("errors", errors);
                req.setAttribute("details", details);
                req.getRequestDispatcher("update-details.jsp").forward(req, resp);
                return;
            }

            resp.sendRedirect("items");
        }
    }
}