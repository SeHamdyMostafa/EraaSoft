<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.item.models.item_details" %>

<%
    item_details d = (item_details) request.getAttribute("details");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Item Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-5">

    <div class="card p-4 bg-white">

        <h3 class="text-center">📦 Update Item Details</h3>

        <% if (d == null) { %>

            <div class="alert alert-danger text-center">
                ❌ No details found for this item
            </div>

            <a href="items" class="btn btn-secondary w-100 mt-2">
                ← Back
            </a>

        <% } else { %>

            <!-- UPDATE FORM -->
            <form method="post" action="item-details">

                <input type="hidden" name="action" value="update">
                <input type="hidden" name="itemId" value="<%= d.getItemId() %>">

                <div class="mb-3">
                    <label>Description</label>
                    <input type="text" name="description"
                           value="<%= d.getDescription() %>"
                           class="form-control" required>
                </div>

                <div class="mb-3">
                    <label>Color</label>
                    <input type="text" name="color"
                           value="<%= d.getColor() %>"
                           class="form-control" required>
                </div>

                <div class="mb-3">
                    <label>Weight</label>
                    <input type="text" name="weight"
                           value="<%= d.getWeight() %>"
                           class="form-control" required>
                </div>

                <button class="btn btn-warning w-100">
                    Update
                </button>

            </form>

        <% } %>

        <a href="items" class="btn btn-secondary w-100 mt-3">
            ← Back
        </a>

    </div>

</div>

</body>
</html>