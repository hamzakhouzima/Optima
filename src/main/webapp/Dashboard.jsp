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
                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal1"  ><i class="bi bi-plus"></i></button>


                   <table class="table">
                       <thead>
<%--                       <tr>--%>
                        <%
                            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
//                            if(employees!=null){
                            for (Employee employee : employees) {
                        %>
                        <tr>
                            <td>  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-employee-id="<%=employee.getId()%>"><i class="bi bi-pencil"></i></button></td>
                            <td>  <button type="button" class="btn btn-danger" id="deleteButton" data-bs-toggle="modal" data-bs-target="#deleteModal" data-delete-employee-id="<%=employee.getId()%>"><i class="bi bi-trash"></i></button> </td>
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
<%--                        <%--%>
<%--                            }--%>
<%--                        %>--%>
<%--                       </tr>--%>
<%--                       </thead>--%>
<%--                       <tbody>--%>
<%--                       <tr>--%>
<%--                           <th scope="row">1</th>--%>
<%--                           <td>Mark</td>--%>
<%--                           <td>Otto</td>--%>
<%--                           <td>@mdo</td>--%>
<%--                       </tr>--%>

<%--                       </tbody>--%>
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
                <form action="/demo12_war_exploded/admin/EditEmployee/" method="post">
                    <div class="mb-3">
                        <label for="first-name" class="col-form-label">First name :</label>
                        <input type="text" class="form-control" id="first-name" name="u_first">
                    </div>
                    <input type="hidden" name="employeeId" id="employeeId">
                    <div class="mb-3">
                        <label for="last-name" class="col-form-label">Last name:</label>
                        <input type="text" class="form-control" id="last-name" name="u_last">
                    </div>
                    <div class="mb-3">
                        <label for="u_email" class="col-form-label">Email:</label>
                        <input type="text" class="form-control"  id="u_email" name="u_email">
                    </div>
                    <div class="mb-3">
                        <label for="u_username" class="col-form-label">UserName:</label>
                        <input type="text" class="form-control"  id="u_username" name="u_username">
                    </div>
                    <div class="mb-3">
                        <label for="u_date" class="col-form-label">Date:</label>
                        <input type="text" class="form-control"  id="u_date" name="u_date">
                    </div>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" value="Submit">

            </div>
                </form>
            </div>
            <div class="modal-footer">

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
                <form action="/demo12_war_exploded/admin/AddEmployee" method="post">
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
                    <input type="text" id="selectedValue" readonly name="role">
<%--                    <button class="btn btn-secondary dropdown-toggle">--%>
                          <span class="button__text">Add</span>
                     //   <button type="submit" class="btn btn-primary">Submit</button>
                            <input type="submit" value="Submit">

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


<%------------------------Validate Delete----------------------%>

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Delete Employee</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete the employee?</p>
                <form id="deleteForm" action="/demo12_war_exploded/admin/DeleteEmployee/" method="post">
                    <input type="text" name="employeeId" id="deleteEmployeeId" >
                    <button type="submit" value="Submit" class="btn btn-danger" id="confirmDelete">Delete</button>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<%------------------------Validate Delete----------------------%>


<%--JSCRIPT--%>
<!-- Include jQuery library -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
    $(document).ready(function () {
        // When a dropdown item is clicked
        $('.dropdown-item').on('click', function () {
            // Get the value from the data-value attribute
            var selectedValue = $(this).data('value');
            $('#selectedValue').val(selectedValue);

            // Set the selected value µ);
        });
    });
</script>


<%--this is ajax id to send the id when the button is  clicked to update employee --%>
<script>

    $(document).ready(function () {
        // Listen for a click event on buttons with the "btn-primary" class that have the data-employee-id attribute
        $('button.btn-primary[data-employee-id]').on('click', function () {
            // Retrieve the employeeId from the data-employee-id attribute
            var employeeId = $(this).data('employee-id');

            // Set the value of the hidden input field with id "employeeId"
            $('#employeeId').val(employeeId);

            console.log("Button clicked, employeeId: " + employeeId);
        });
    });

    // delete id catcher
    $(document).ready(function () {
        // Listen for a click event on buttons with the "btn-danger" class that have the data-delete-employee-id attribute
        $('button.btn-danger[data-delete-employee-id]').on('click', function () {
            // Retrieve the employeeId from the data-delete-employee-id attribute
            var delete_id = $(this).data('delete-employee-id');

            // Set the value of the input field with id "deleteid"
            $('#deleteEmployeeId').val(delete_id);
            console.log("Button clicked, delete_id: " + delete_id);
        });
    });

    <%--<td>  <button type="button" class="btn btn-danger"  data-bs-toggle="modal" data-bs-target="#deleteModal" delete-employee-id="<%=employee.getId()%>"><i class="bi bi-trash"></i></button> </td>--%>


</script>
<%--JSCRIPT--%>

</body>
</html>
