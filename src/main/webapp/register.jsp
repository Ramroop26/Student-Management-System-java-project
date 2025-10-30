<%@ include file="includes/header.jsp" %>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card shadow-sm">
            <div class="card-body">
                <h3 class="card-title mb-3">Register</h3>
                <% if(request.getParameter("error") != null) { %>
                    <div class="alert alert-danger">Registration failed — try again.</div>
                <% } %>
                <form action="register" method="post">
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input class="form-control" type="text" name="name" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input class="form-control" type="email" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input class="form-control" type="password" name="password" required>
                    </div>
                    <button class="btn btn-primary w-100">Register</button>
                </form>
                <p class="mt-3 text-center">Already have an account? <a href="login.jsp">Login</a></p>
            </div>
        </div>
    </div>
</div>
<%@ include file="includes/footer.jsp" %>
