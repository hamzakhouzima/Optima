<%@ page import="com.optima.demo12.Database.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.optima.demo12.Database.Equipement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="<%= request.getLocale().toString().replace('_', '-') %>">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- CSRF Token -->
  <!-- <meta name="csrf-token" content="<%= request.getAttribute("org.springframework.security.web.csrf.CsrfToken") %>"> -->
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
      <!-- fetch the employee data and display them -->

      <div class="container-fluid overflow-auto" style="max-height: 80vh;margin-top: 2cm">
        <!-- Button to add a new employee -->
        <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addEmployeeModal"><i class="bi bi-plus"></i></button>

        <div class="container">
          <div class="row">
            <%
              List<Equipement> equipements = (List<Equipement>) request.getAttribute("equipements");
              if (equipements != null) {
                for (Equipement equipement : equipements) {
            %>
            <div class="col-md-4 mb-4">
              <div class="card">
                <!-- Add the image source for the equipment if available -->
                <img src="equipment_image.jpg" class="card-img-top" alt="<%= equipement.getType() %>">
                <div class="card-body">
                  <h5 class="card-title"><%= equipement.getType() %></h5>
                  <p class="card-text">Buying Date: <%= equipement.getBuying_date() %></p>
                  <p class="card-text">Maintenance Date: <%= equipement.getMaintenance_date() %></p>
                  <p class="card-text">State: <%= equipement.getState() %></p>
                  <form method="post" action="${pageContext.request.contextPath}/admin/Reservation/">
                    <input type="hidden" name="employeeId" value="<%=  session.getAttribute("User_id")
 %>">
                    <input type="hidden" name="equipementId" value="<%= equipement.getId() %>">
                    <input type="submit" value="Reserve" class="btn btn-primary">
                  </form>
                </div>
              </div>
            </div>
            <%
                }
              }
            %>
          </div>
        </div>      </div>
    </div>
    <footer class="bg-white sticky-footer">
      <div class="container my-auto">
        <div class="text-center my-auto copyright"><span>Copyright © Mon site 2023</span></div>
      </div>
    </footer>
  </div>
  <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>

<!-- Include Bootstrap and jQuery JS files -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.1.1.js"
        integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<!-- Include your custom scripts as needed -->

<!-- Add Employee Modal -->
<div class="modal fade" id="addEmployeeModal" tabindex="-1" aria-labelledby="addEmployeeModalLabel" aria-hidden="true">
  <!-- Modal content for adding a new employee -->
  <!-- Include your HTML for adding a new employee -->
</div>

<!-- Edit Employee Modal -->
<div class="modal fade" id="editEmployeeModal" tabindex="-1" aria-labelledby="editEmployeeModalLabel" aria-hidden="true">
  <!-- Modal content for editing an employee -->
  <!-- Include your HTML for editing an employee -->
</div>

<!-- Delete Employee Modal -->
<div class="modal fade" id="deleteEmployeeModal" tabindex="-1" aria-labelledby="deleteEmployeeModalLabel" aria-hidden="true">
  <!-- Modal content for deleting an employee -->
  <!-- Include your HTML for deleting an employee -->
</div>





<body/>
<html/>




