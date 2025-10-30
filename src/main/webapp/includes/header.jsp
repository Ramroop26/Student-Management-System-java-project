<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- ✅ Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- ✅ Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">

    <!-- ✅ Custom CSS -->
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #111, #1a1a40, #ff0080, #ffcc00, #1877f2);
            color: #333;
            min-height: 80vh;
        }

        /* Navbar */
        .navbar {
            background: linear-gradient(135deg, #111, #1a1a40, #1877f2);
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .navbar-brand {
            font-weight: 200;
            font-size: 1.4rem;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .navbar-nav .nav-link {
            color: #fff !important;
            font-weight: 200;
            margin-left: 10px;
            transition: 0.3s ease;
        }

        .navbar-nav .nav-link:hover {
            color: #ffeb3b !important;
            transform: translateY(-1px);
        }

        .nav-item span.nav-link {
            font-weight: 200;
            opacity: 0.9;
        }

        /* Container and cards */
        .container {
            margin-top: 5px;
            margin-bottom: 20px;
        }

        .card {
            border: none;
            border-radius: 15px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.08);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.12);
        }

       .table-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 70vh;
            text-align: center;
        }

        .table {
            border-radius: 10px;
            overflow: hidden;
            background: #fff;
            width: 100%;
            
            
           
        }

        .table thead {
            background: linear-gradient(90deg, #0062cc, #007bff);
            color: #fff;
        }

        .btn {
           border-radius: 10px;
            padding: 6px 16px;
            font-weight: 500;
            transition: 0.3s ease;
        }

        .btn:hover {
            transform: scale(1.05);
            opacity: 0.9;
        }

        footer {
            background: linear-gradient(135deg, #111, #1a1a40, #1877f2);
            color: #fff;
            text-align: center;
            padding: 12px 0;
            font-size: 0.9rem;
            margin-top: 20%;
        }

        /* ✅ RESPONSIVE MEDIA QUERIES */
        @media (max-width: 992px) {
            .navbar-brand {
                font-size: 1.2rem;
            }
            .navbar-nav .nav-link {
                margin-left: 0;
                text-align: center;
                padding: 8px 0;
            }
        }

        @media (max-width: 768px) {
            body {
                background: linear-gradient(135deg, #111, #1a1a40, #1877f2);
            }
            .container {
                padding: 0 10px;
            }
            .table-container {
                padding: 8px;
            }
            .table {
                font-size: 0.9rem;
            }
            footer {
                font-size: 0.8rem;
            }
        }

        @media (max-width: 576px) {
            .navbar-brand {
                font-size: 1rem;
            }
            h3, .card-title {
                font-size: 1.1rem;
            }
            .btn {
                font-size: 0.85rem;
                padding: 5px 12px;
            }
            .table thead {
                font-size: 0.8rem;
            }
            .table tbody {
                font-size: 0.8rem;
            }
        }
    </style>
</head>
<body>

<!-- ✅ Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="list">Student Management System</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#nav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="nav">
            <ul class="navbar-nav ms-auto">
                <%
                    com.model.User logged = (com.model.User) session.getAttribute("user");
                    if (logged != null) {
                %>
                    <li class="nav-item"><a class="nav-link" href="list">Students</a></li>
                    <li class="nav-item"><a class="nav-link" href="add_student.jsp">Add</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
                    <li class="nav-item"><span class="nav-link text-white">Welcome, <%= logged.getName() %></span></li>
                <%
                    } else {
                %>
                    <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <!-- Your page content here -->
</div>



<!-- ✅ Bootstrap JS -->

</body>
</html>
