package com.optima.demo12.Http;
import java.util.*;
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

@WebServlet(name="AdminServlet", urlPatterns={"/demo12_war_exploded/admin/DeleteEmployee/"})
public class DeleteEmpServlet extends HttpServlet {
    @PersistenceUnit(unitName = "default")
    private EntityManager entityManager;
//    EmployeeService employeeList = new EmployeeService();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the employee ID that you want to update


        System.out.println("edit this employee id:"+  request.getParameter("employeeId"));
//        System.out.println(request.toString());

        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        // Retrieve the existing employee entity from the database
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.getEmployeeById(employeeId);
        employeeService.deleteEmployee(employee);

        List<Employee> employees = employeeService.displayEmployees();
        request.setAttribute("employees", employees);

        // Forward the request to a JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard.jsp");
        dispatcher.include(request, response);
    }


}
