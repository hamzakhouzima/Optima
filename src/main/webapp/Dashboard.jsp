<%@ page import="com.optima.demo12.Database.Employee" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html lang="<%= request.getLocale().toString().replace('_', '-') %>">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- CSRF Token -->
<%--    <meta name="csrf-token" content="<%= request.getAttribute("org.springframework.security.web.csrf.CsrfToken") %>">--%>
    <title>Optima</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.9.1/font/bootstrap-icons.min.css"
          integrity="sha512-5PV92qsds/16vyYIJo3T/As4m2d8b6oWYfoqV+vtizRB6KhF1F9kYzWzQmsO6T3z3QG2Xdhrx7FQ+5R1LiQdUA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="content}/fonts/fontawesome-all.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css"/>
</head>
<body id="page-top">
<div id="wrapper">
    <%@ include file="views/components/sidebar.jsp" %>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <%@ include file="views/components/header.jsp" %>
<%-- fetch the employee data and display them          --%>

            <div class="container-fluid overflow-auto" style="max-height: 80vh;margin-top: 2cm">
               <%-- <jsp:include page="your_content.jsp" />--%>
                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal1"><i class="bi bi-plus"></i></button>


                   <table class="table">
                       <thead>
<%--                       <tr>--%>
                        <%
                            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                            for (Employee employee : employees) {
                        %>
                        <tr>
                            <td>  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="bi bi-pencil"></i></button></td>

<%--                            <td><%= employee.getId() %></td>--%>
                            <td><%= employee.getUsername() %></td>
                            <td><%= employee.getFirstName() %></td>
                            <td><%= employee.getLastName() %></td>
                            <td><%= employee.getEmail() %></td>
                            <td><%= employee.getRole().getRole() %></td>
                        </tr>
                        <%
                            }
                        %>
<%--                       </tr>--%>
                       </thead>
                       <tbody>
                       <tr>
                           <th scope="row">1</th>
                           <td>Mark</td>
                           <td>Otto</td>
                           <td>@mdo</td>
                       </tr>

                       </tbody>
                   </table>
<%--                --%>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Mon site  2023</span></div>
            </div>
        </footer>
    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.1.1.js"
        integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<%-- Include your custom scripts as needed --%>
<%--
<jsp:include page="your_scripts.jsp" />
--%>



<%------------------------Modify Modal----------------------------------%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Recipient:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="mb-3">
                        <label for="message-text" class="col-form-label">Message:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Send message</button>
            </div>
        </div>
    </div>
</div>

<%------------------------Modify Modal----------------------------------%>

<%------------------------Add Modal----------------------------------%>
<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">New message</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/demo12_war_exploded/admin/Dashboard" method="post">
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">First name:</label>
                        <input type="text" class="form-control" id="recipient-name1" name="firstName">
                    </div>
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Last name:</label>
                        <input type="text" class="form-control" id="recipient-name2"  name="lastName">
                    </div>
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Email:</label>
                        <input type="text" class="form-control" id="recipient-name3"  name="email">
                    </div>
                    <div class="mb-3">
                        <label for="message-text" class="col-form-label">Description:</label>
                        <textarea class="form-control" id="message-text1" name="description"></textarea>
                    </div>
<%--      DropDown              --%>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown button
                        </button>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownMenuButton">
                            <li><a class="dropdown-item" href="#" data-value="1">Admin</a></li>
                            <li><a class="dropdown-item" href="#" data-value="2">HR</a></li>
                            <li><a class="dropdown-item" href="#" data-value="3">Supervisor</a></li>
                            <li><a class="dropdown-item" href="#" data-value="4">Employee</a></li>

                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#" data-value="Separated link">Separated link</a></li>
                        </ul>
                    </div>

                    <!-- Input fields to display the selected value -->
                    <input type="hidden" id="selectedValue" readonly name="role">
                    <button class="btn btn-secondary dropdown-toggle">
                        <span class="button__text">Add</span>
                        <button class="btn btn-secondary dropdown-toggle" type="button" aria-expanded="false">
                        <input type="submit" value="Submit">
                        </button>

                        <i class="button__icon fas fa-chevron-right"></i>
                    </button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Send message</button>
            </div>
        </div>
    </div>
</div>
<%------------------------Add Modal----------------------------------%>



<%--JSCRIPT--%>
<!-- Include jQuery library -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
    $(document).ready(function () {
        // When a dropdown item is clicked
        $('.dropdown-item').on('click', function () {
            // Get the value from the data-value attribute
            var selectedValue = $(this).data('value');

            // Set the selected value to the input field
            $('#selectedValue').val(selectedValue);
        });
    });
</script>

<%--JSCRIPT--%>

</body>
</html>
