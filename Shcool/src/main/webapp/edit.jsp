<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.student.models.StudentModel" %>

<%
    StudentModel s =
            (StudentModel) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>

    <title>Edit Student</title>

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

        /* زرار الحفظ */
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

        /* زر الرجوع */
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
            ✏ Edit Student
        </h2>

        <form method="post" action="students">

            <input type="hidden" name="action" value="update">

            <input type="hidden"
                   name="id"
                   value="<%= s.getId() %>">

            <div class="mb-3">

                <label class="form-label fw-bold">Name</label>

                <input type="text"
                       name="name"
                       class="form-control"
                       value="<%= s.getName() %>"
                       required>

            </div>

            <div class="mb-3">

                <label class="form-label fw-bold">Age</label>

                <input type="number"
                       name="age"
                       class="form-control"
                       value="<%= s.getAge() %>"
                       required>

            </div>

            <div class="d-flex gap-2">

                <button class="btn btn-success w-50">
                    Save Changes
                </button>

                <a href="students"
                   class="btn btn-secondary w-50">
                    Back
                </a>

            </div>

        </form>

    </div>

</div>

</body>
</html>