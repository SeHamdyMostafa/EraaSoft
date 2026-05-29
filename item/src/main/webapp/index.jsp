<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, org.item.models.ItemModel" %>

<%
    List<ItemModel> items = (List<ItemModel>) request.getAttribute("items");
    List<String> errors = (List<String>) request.getAttribute("errors");
    String error = (String) request.getAttribute("error");

    Map<Integer, Boolean> hasDetailsMap =
        (Map<Integer, Boolean>) request.getAttribute("hasDetailsMap");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Items System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #667eea, #764ba2);
            min-height: 100vh;
            font-family: 'Segoe UI', sans-serif;
        }

        .card {
            border: none;
            border-radius: 18px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.25);
        }

        /* ACTIONS WRAPPER */
        .actions {
            display: flex;
            gap: 8px;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
        }

        /* BASE BUTTON STYLE */
        .action-btn {
            padding: 6px 12px;
            border-radius: 8px;
            font-size: 13px;
            font-weight: 500;
            transition: 0.2s ease-in-out;
            text-decoration: none;
            border: 1px solid transparent;
            cursor: pointer;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            min-width: 90px;
            background: transparent;
        }

        /* UPDATE */
        .btn-update {
            border: 1px solid #ffc107;
            color: #ffc107;
        }
        .btn-update:hover {
            background: #ffc107;
            color: #000;
        }

        /* VIEW */
        .btn-view {
            border: 1px solid #0dcaf0;
            color: #0dcaf0;
        }
        .btn-view:hover {
            background: #0dcaf0;
            color: #000;
        }

        /* ADD */
        .btn-add {
            border: 1px solid #198754;
            color: #198754;
        }
        .btn-add:hover {
            background: #198754;
            color: #fff;
        }

        /* DELETE */
        .btn-delete {
            border: 1px solid #dc3545;
            color: #dc3545;
        }
        .btn-delete:hover {
            background: #dc3545;
            color: #fff;
        }
    </style>
</head>

<body>

<div class="container mt-5">

    <nav class="d-flex justify-content-between align-items-center mb-4">
        <h3 class="text-white">📦 Items System</h3>

        <a href="auth?action=logout" class="btn btn-outline-light">
            Logout
        </a>
    </nav>

    <div class="card p-4 bg-white">

        <!-- ERRORS -->
        <% if (error != null) { %>
            <div class="alert alert-danger"><%= error %></div>
        <% } %>

        <% if (errors != null) {
            for (String e : errors) { %>
                <div class="alert alert-danger"><%= e %></div>
        <%  }
        } %>

        <!-- ADD FORM -->
        <form method="post" action="items">
            <input type="hidden" name="action" value="add">

            <div class="row mb-3">

                <div class="col-md-5">
                    <input type="text" name="name" class="form-control" placeholder="Item Name" required>
                </div>

                <div class="col-md-5">
                    <input type="number" step="0.01" name="price" class="form-control" placeholder="Item Price" required>
                </div>

                <div class="col-md-2">
                    <button class="btn btn-primary w-100">Add</button>
                </div>

            </div>
        </form>

        <!-- TABLE -->
        <% if (items == null || items.isEmpty()) { %>

            <div class="alert alert-warning text-center mt-3">
                🚫 No items found
            </div>

        <% } else { %>

            <table class="table table-bordered text-center align-middle">

                <tr class="table-dark">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>

                <% for (ItemModel item : items) {

                    boolean hasDetails =
                        hasDetailsMap != null &&
                        hasDetailsMap.get(item.getId()) != null &&
                        hasDetailsMap.get(item.getId());
                %>

                <tr>
                    <td><%= item.getId() %></td>
                    <td><%= item.getName() %></td>
                    <td><%= item.getPrice() %></td>

                    <td>
                        <div class="actions">

                            <a href="items?action=edit&id=<%= item.getId() %>"
                               class="action-btn btn-update">
                                Update
                            </a>

                            <% if (hasDetails) { %>

                                <a href="item-details?action=details&itemId=<%= item.getId() %>"
                                   class="action-btn btn-view">
                                    View
                                </a>

                            <% } else { %>

                                <a href="item-details?action=addForm&itemId=<%= item.getId() %>"
                                   class="action-btn btn-add">
                                    Add
                                </a>

                            <% } %>

                            <form method="post" action="items" style="margin:0;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="<%= item.getId() %>">

                                <button class="action-btn btn-delete" type="submit">
                                    Delete
                                </button>
                            </form>

                        </div>
                    </td>
                </tr>

                <% } %>

            </table>

        <% } %>

    </div>
</div>

</body>
</html>