package com.optima.demo12.Http;


//import com.optima.demo12.Database.HibernateUtil;
import com.optima.demo12.Database.Employee;
import com.optima.demo12.Service.EmployeeService;
import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name="AdminServlet", urlPatterns={"/demo12_war_exploded/admin/Dashboard"})

public class AdminServlet extends HttpServlet {

    @PersistenceUnit(unitName = "default")
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    EmployeeService employeeList = new EmployeeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Your servlet logic
//    employeeList.displayEmployees();
//        System.out.println(employeeList);
      //  employeeList.displayEmployees().forEach(employee-> System.out.println(employee));
        request.setAttribute("employees", employeeList.displayEmployees());

        // Forward the request to a JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard.jsp"); //create a jsp file and send a get Request
        dispatcher.include(request, response);


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
//        String date = request.getParameter("date");



        Employee employee = new Employee();
//        employee.setUsername(username);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setPassword(role);
//        employee.setDate(date);
//       employee.setDepartment(1);

        EmployeeService employeeService = new EmployeeService();

        employeeService.AddEmployee(employee);


    }

}
