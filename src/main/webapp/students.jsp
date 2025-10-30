<%@ page import="java.util.List" %>
<%@ page import="com.model.Student" %>
<%@ include file="includes/header.jsp" %>


<a class="btn btn-success mb-3" href="add_student.jsp">Add New Student</a>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
        <tr><th>ID</th><th>Name</th><th>Course</th><th>Email</th><th>Action</th></tr>
    </thead>
    <tbody>
    <%
        List<Student> list = (List<Student>) request.getAttribute("students");
        if (list != null) {
            for (Student s : list) {
    %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getCourse() %></td>
            <td><%= s.getEmail() %></td>
            <td>
                <a class="btn btn-warning btn-sm"
                   href="edit_student.jsp?id=<%=s.getId()%>&name=<%=java.net.URLEncoder.encode(s.getName(), "UTF-8")%>&course=<%=java.net.URLEncoder.encode(s.getCourse(), "UTF-8")%>&email=<%=java.net.URLEncoder.encode(s.getEmail(), "UTF-8")%>">Edit</a>
                <a class="btn btn-danger btn-sm" href="delete?id=<%= s.getId() %>" onclick="return confirm('Delete this student?');">Delete</a>
            </td>
        </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<%@ include file="includes/footer.jsp" %>
