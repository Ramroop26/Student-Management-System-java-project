<%@ include file="includes/header.jsp" %>

<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String course = request.getParameter("course");
    String email = request.getParameter("email");
%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8">
            <div class="card shadow-lg border-0">
                <div class="card-body p-4">
                    <h3 class="card-title text-center mb-4 text-success fw-semibold">
                         Edit Student
                    </h3>
                    <form action="edit" method="post">
                        <input type="hidden" name="id" value="<%= id %>">

                        <div class="mb-3">
                            <label class="form-label fw-medium">Name</label>
                            <input class="form-control" type="text" name="name" value="<%= name %>" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label fw-medium">Course</label>
                            <input class="form-control" type="text" name="course" value="<%= course %>" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label fw-medium">Email</label>
                            <input class="form-control" type="email" name="email" value="<%= email %>" required>
                        </div>

                        <div class="d-grid mt-4">
                            <button class="btn btn-success btn-lg" type="submit">Update Student</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
