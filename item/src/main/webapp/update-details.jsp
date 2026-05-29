<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.item.models.item_details" %>

<%
    item_details d = (item_details) request.getAttribute("details");
    int itemId = (Integer) request.getAttribute("itemId");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Details</title>

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
            max-width: 600px;
            margin: auto;
        }

        h3 {
            font-weight: bold;
            margin-bottom: 25px;
            text-align: center;
        }

        .form-control {
            border-radius: 10px;
            padding: 10px;
        }

        .btn {
            border-radius: 10px;
            font-weight: 500;
            transition: 0.2s;
        }

        .btn-warning:hover {
            background: #d39e00;
            color: #fff;
        }

        .btn-secondary:hover {
            background: #5c636a;
        }

        .form-box {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 12px;
        }
    </style>
</head>

<body>

<div class="container mt-5">

    <div class="card p-4 bg-white">

        <h3>✏ Update Item Details</h3>

        <div class="form-box">

            <form method="post" action="item-details">

                <input type="hidden" name="action" value="update">
                <input type="hidden" name="itemId" value="<%= itemId %>">

                <label class="form-label">Description</label>
                <input type="text" name="description"
                       value="<%= d.getDescription() %>"
                       class="form-control mb-3"
                       placeholder="Enter description">

                <label class="form-label">Color</label>
                <input type="text" name="color"
                       value="<%= d.getColor() %>"
                       class="form-control mb-3"
                       placeholder="Enter color">

                <label class="form-label">Weight</label>
                <input type="text" name="weight"
                       value="<%= d.getWeight() %>"
                       class="form-control mb-3"
                       placeholder="Enter weight">

                <button class="btn btn-warning w-100">
                    Update
                </button>

            </form>

        </div>

        <a href="items" class="btn btn-secondary w-100 mt-3">
            ← Back
        </a>

    </div>

</div>

</body>
</html>