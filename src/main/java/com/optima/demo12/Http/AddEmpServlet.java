package com.optima.demo12.Http;

import com.optima.demo12.Database.Employee;
import com.optima.demo12.Service.EmployeeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="AdminServlet", urlPatterns={"/demo12_war_exploded/admin/AddEmployee"})
public class AddEmpServlet extends HttpServlet {
    @PersistenceUnit(unitName = "default")
    private EntityManager entityManager;
    EmployeeService employeeList = new EmployeeService();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = "radomPAssw";
        String role = request.getParameter("role");
//        String date = request.getParameter("date");

        System.out.println(firstName+lastName+email+password+role);

        System.out.println("post method is running ");


        Employee employee = new Employee();
//        employee.setUsername(username);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setRoleId(role);
        employee.setDepId("1");

        employeeList.AddEmployee(employee);
        response.sendRedirect(request.getContextPath() + "/admin/Dashboard");



    }

}
