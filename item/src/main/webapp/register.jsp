<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>

    <title>Register</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        body{
            background: linear-gradient(135deg,#74ebd5,#ACB6E5);
            min-height:100vh;
        }

        .card{
            border:none;
            border-radius:20px;
        }

        .form-control{
            border-radius:12px;
            padding:12px;
        }

        .btn-register{
            background:#198754;
            color:white;
            border-radius:12px;
            padding:10px;
            font-weight:bold;
            border:2px solid #198754;
            transition:.3s;
        }

        .btn-register:hover{
            background:white;
            color:#198754;
        }

    </style>

</head>

<body>

<div class="container">

    <div class="row justify-content-center align-items-center vh-100">

        <div class="col-md-5">

            <div class="card shadow p-4">

                <h2 class="text-center mb-4">
                    Create Account
                </h2>

                <%
                    List<String> errors =
                            (List<String>) request.getAttribute("errors");

                    if(errors != null){
                        for(String error : errors){
                %>

                <div class="alert alert-danger">
                    <%= error %>
                </div>

                <%
                        }
                    }
                %>

                <form method="post" action="auth" autocomplete="off">

                    <input type="hidden"
                           name="action"
                           value="register">

                    <div class="mb-3">

                        <input type="text"
                               name="username"
                               class="form-control"
                               placeholder="Username"
                               autocomplete="off"
                               required>

                    </div>

                    <div class="mb-3">

                        <input type="email"
                               name="email"
                               class="form-control"
                               placeholder="Email"
                               autocomplete="off"
                               required>

                    </div>

                    <div class="mb-3">

                        <input type="password"
                               name="password"
                               class="form-control"
                               placeholder="Password"
                               autocomplete="off"
                               required>

                    </div>

                    <button class="btn btn-register w-100">
                        Register
                    </button>

                </form>

                <div class="text-center mt-3">

                    <a href="auth">
                        Already have account?
                    </a>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>