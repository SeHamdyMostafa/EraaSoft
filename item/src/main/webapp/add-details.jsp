<%@ page contentType="text/html;charset=UTF-8" %>

<%
    int itemId = Integer.parseInt(request.getParameter("itemId"));
%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Details</title>

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
            text-align: center;
            margin-bottom: 25px;
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

        .btn-success:hover {
            background: #157347;
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

        <h3>➕ Add Item Details</h3>

        <div class="form-box">

            <form method="post" action="item-details">

                <input type="hidden" name="action" value="add">
                <input type="hidden" name="itemId" value="<%= itemId %>">

                <label class="form-label">Description</label>
                <input type="text" name="description"
                       class="form-control mb-3"
                       placeholder="Enter description">

                <label class="form-label">Color</label>
                <input type="text" name="color"
                       class="form-control mb-3"
                       placeholder="Enter color">

                <label class="form-label">Weight</label>
                <input type="text" name="weight"
                       class="form-control mb-3"
                       placeholder="Enter weight">

                <button class="btn btn-success w-100">
                    Save
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