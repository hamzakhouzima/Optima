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
    private EntityManager entityManager;

    EmployeeService employeeList = new EmployeeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Your servlet logic
//    employeeList.displayEmployees();
//        System.out.println(employeeList);
      //  employeeList.displayEmployees().forEach(employee-> System.out.println(employee));


        request.setAttribute("employees", employeeList.displayEmployees());

        // Forward the request to a JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard.jsp");
        dispatcher.include(request, response);


    }



}
