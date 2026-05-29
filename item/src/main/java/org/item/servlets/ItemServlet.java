package org.item.servlets;

import org.item.models.ItemModel;
import org.item.service.ItemService;
import org.item.service.itemDetailsService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemServlet extends HttpServlet {

    ItemService service = new ItemService();
    itemDetailsService detailsService = new itemDetailsService();

    private Integer getUserId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return null;
        }
        return (Integer) session.getAttribute("userId");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = getUserId(req, resp);
        if (userId == null) return;
        String action = req.getParameter("action");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            ItemModel item = service.getItemById(id, userId);
            if (item == null) {
                resp.sendRedirect("items");
                return;
            }
            req.setAttribute("item", item);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
            return;
        }

        List<ItemModel> items = service.getAllItems(userId);
        Map<Integer, Boolean> map = new HashMap<>();
        for (ItemModel item : items) {
            map.put(item.getId(), detailsService.hasItemDetails(item.getId()));
        }
        req.setAttribute("items", items);
        req.setAttribute("hasDetailsMap", map);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        Integer userId = getUserId(req, resp);
        if (userId == null) return;

        String action = req.getParameter("action");

        try {
            if ("add".equals(action)) {

                ItemModel item = new ItemModel();
                item.setName(req.getParameter("name"));
                item.setPrice(Double.parseDouble(req.getParameter("price")));
                item.setUserId(userId);

                List<String> errors = service.addItem(item);
                if (!errors.isEmpty()) {
                    req.setAttribute("errors", errors);
                    req.setAttribute("items", service.getAllItems(userId));
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    return;
                }

                resp.sendRedirect("items");
                return;
            }

            else if ("update".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));
                ItemModel item = new ItemModel();
                item.setName(req.getParameter("name"));
                item.setPrice(Double.parseDouble(req.getParameter("price")));
                item.setUserId(userId);

                List<String> errors = service.updateItem(id, item);
                if (!errors.isEmpty()) {
                    req.setAttribute("errors", errors);
                    req.setAttribute("item", service.getItemById(id, userId));
                    req.getRequestDispatcher("edit.jsp").forward(req, resp);
                    return;
                }

                resp.sendRedirect("items");
                return;
            }

            else if ("delete".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));
                service.deleteItem(id, userId);
                resp.sendRedirect("items");
                return;
            }
            resp.sendRedirect("items");

        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid number format");
            req.setAttribute("items", service.getAllItems(userId));
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}