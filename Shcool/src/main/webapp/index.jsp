<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, org.student.models.StudentModel" %>

<%
    List<StudentModel> students =
            (List<StudentModel>) request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
<head>

    <title>Students System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

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

        .title {
            color: white;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
            text-shadow: 2px 2px 10px rgba(0,0,0,0.3);
        }

        /* inputs */
        .form-control {
            border-radius: 12px;
            padding: 10px;
        }

        .form-control:focus {
            box-shadow: 0 0 10px rgba(102,126,234,0.5);
            border-color: #667eea;
        }

        /* add button */
        .btn-primary {
            background: linear-gradient(45deg, #667eea, #764ba2);
            border: none;
            border-radius: 12px;
        }

        .btn-primary:hover {
            transform: scale(1.05);
        }

        /* ===== ACTION BUTTONS ===== */
        .action-btn {
            border: 2px solid transparent;
            padding: 10px 18px;
            border-radius: 14px;
            font-size: 14px;
            font-weight: 600;
            transition: all 0.25s ease;
            display: inline-block;
            text-decoration: none;
            cursor: pointer;
        }

        /* UPDATE */
        .btn-update {
            background: #ffffff;
            color: #f59e0b;
            border: 2px solid #f59e0b;
        }

        .btn-update:hover {
            background: #f59e0b;
            color: #fff;
            transform: translateY(-2px);
            box-shadow: 0 8px 18px rgba(245, 158, 11, 0.3);
        }

        /* DELETE */
        .btn-delete {
            background: #ffffff;
            color: #ef4444;
            border: 2px solid #ef4444;
        }

        .btn-delete:hover {
            background: #ef4444;
            color: #fff;
            transform: translateY(-2px);
            box-shadow: 0 8px 18px rgba(239, 68, 68, 0.3);
        }

        /* table */
        .table {
            border-radius: 12px;
            overflow: hidden;
        }

        .table-dark {
            background: linear-gradient(45deg, #343a40, #212529);
        }

        tbody tr:hover {
            background: #f1f1f1;
            transform: scale(1.01);
            transition: 0.2s;
        }

    </style>

</head>

<body>

<div class="container mt-5">

    <h2 class="title">🎓 Students System</h2>

    <div class="card p-4 bg-white">

        <!-- ADD FORM -->
        <form method="post" action="students">

            <input type="hidden" name="action" value="add">

            <div class="row mb-4">

                <div class="col-md-5">
                    <input type="text" name="name"
                           class="form-control"
                           placeholder="Student Name"
                           required>
                </div>

                <div class="col-md-5">
                    <input type="number" name="age"
                           class="form-control"
                           placeholder="Student Age"
                           required>
                </div>

                <div class="col-md-2">
                    <button class="btn btn-primary w-100">
                        Add
                    </button>
                </div>

            </div>

        </form>

        <!-- TABLE -->
        <table class="table table-bordered table-hover text-center">

            <tr class="table-dark">
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>

            <%
                if (students != null) {
                    for (StudentModel s : students) {
            %>

            <tr>

                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getAge() %></td>

                <td>

                    <!-- UPDATE -->
                    <a href="students?action=edit&id=<%= s.getId() %>"
                       class="action-btn btn-update">
                        Update
                    </a>

                    <!-- DELETE -->
                    <form method="post"
                          action="students"
                          style="display:inline;">

                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="<%= s.getId() %>">

                        <button class="action-btn btn-delete"
                                onclick="return confirm('Are you sure you want to delete?')">
                            Delete
                        </button>

                    </form>

                </td>

            </tr>

            <%
                    }
                }
            %>

        </table>

    </div>

</div>

</body>
</html>