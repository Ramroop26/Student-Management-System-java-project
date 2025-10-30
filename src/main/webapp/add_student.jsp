<%@ include file="includes/header.jsp" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8">
            <div class="card shadow-lg border-0">
                <div class="card-body p-4">
                    <h3 class="card-title text-center mb-4 text-primary fw-semibold">
                         Add New Student
                    </h3>
                    <form action="add" method="post">
                        <div class="mb-3">
                            <label class="form-label fw-medium">Name</label>
                            <input class="form-control" type="text" name="name" placeholder="Enter student name" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label fw-medium">Course</label>
                            <input class="form-control" type="text" name="course" placeholder="Enter course name" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label fw-medium">Email</label>
                            <input class="form-control" type="email" name="email" placeholder="Enter email address" required>
                        </div>
                        <div class="d-grid mt-4">
                            <button class="btn btn-primary btn-lg" type="submit">Add Student</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
