<%@ include file="includes/header.jsp" %>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card shadow-sm">
            <div class="card-body">
                <h3 class="card-title mb-3">Login</h3>

                <% if(request.getParameter("msg") != null && "registered".equals(request.getParameter("msg"))) { %>
                    <div class="alert alert-success">Registered successfully. Please login.</div>
                <% } %>

                <% if(request.getParameter("error") != null) { %>
                    <div class="alert alert-danger">Invalid email or password.</div>
                <% } %>

                <form action="login" method="post">
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input class="form-control" type="email" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input class="form-control" type="password" name="password" required>
                    </div>
                    <button class="btn btn-success w-100">Login</button>
                </form>

                <p class="mt-3 text-center">New here? <a href="register.jsp">Register</a></p>
            </div>
        </div>
    </div>
</div>
<%@ include file="includes/footer.jsp" %>
