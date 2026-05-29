<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.item.models.ItemModel" %>

<%
    ItemModel item = (ItemModel) request.getAttribute("item");

    if (item == null) {
%>

<!DOCTYPE html>
<html>
<head>
    <title>Item Not Found</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5 text-center">

    <div class="alert alert-danger">
        Item not found or invalid request
    </div>

    <a href="items" class="btn btn-primary">
        Back to Items
    </a>

</div>

</body>
</html>

<%
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>

    <title>Edit Item</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        body {
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
            min-height: 100vh;
        }

        .card {
            border-radius: 15px;
            border: none;
        }

        h2 {
            font-weight: bold;
            color: #333;
        }

        .form-control {
            border-radius: 10px;
            padding: 10px;
        }

        .btn-success {
            padding: 10px 25px;
            border-radius: 12px;
            font-weight: bold;
            border: 2px solid #198754;
            transition: 0.3s;
        }

        .btn-success:hover {
            background: white;
            color: #198754;
        }

        .btn-secondary {
            padding: 10px 25px;
            border-radius: 12px;
            font-weight: bold;
            border: 2px solid #6c757d;
            transition: 0.3s;
        }

        .btn-secondary:hover {
            background: white;
            color: #6c757d;
        }

    </style>

</head>

<body>

<div class="container mt-5">

    <div class="card shadow p-4">

        <h2 class="mb-4 text-center">
            ✏ Edit Item
        </h2>

        <%
            List<String> errors = (List<String>) request.getAttribute("errors");

            if (errors != null) {
                for (String e : errors) {
        %>

        <div class="alert alert-danger">
            <%= e %>
        </div>

        <%
                }
            }
        %>

        <form method="post" action="items">

            <input type="hidden" name="action" value="update">

            <input type="hidden" name="id" value="<%= item.getId() %>">

            <div class="mb-3">

                <label class="form-label fw-bold">Name</label>

                <input type="text"
                       name="name"
                       class="form-control"
                       value="<%= item.getName() %>"
                       required>

            </div>

            <div class="mb-3">

                <label class="form-label fw-bold">Price</label>

                <input type="number"
                       step="0.01"
                       name="price"
                       class="form-control"
                       value="<%= item.getPrice() %>"
                       required>

            </div>

            <div class="d-flex gap-2">

                <button class="btn btn-success w-50">
                    Save Changes
                </button>

                <a href="items" class="btn btn-secondary w-50">
                    Back
                </a>

            </div>

        </form>

    </div>

</div>

</body>
</html>