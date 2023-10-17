package com.optima.demo12.Http;

import com.optima.demo12.Database.Employee;
import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MyLoginServlet")
public class LoginServlet extends HttpServlet {
    @PersistenceContext(unitName = "default")
   // private EntityManager entityManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the login page (login.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isUserValid(email, password, response)) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }

    }

    private boolean isUserValid(String email, String password, HttpServletResponse response) throws IOException {
        // Query the database for an employee with the specified email

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

      //  String hql = "FROM Employee WHERE email = :email";

        String jpql = "SELECT e FROM Employee e WHERE e.email = :email";
      //  String checkRole = "SELECT ";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("email", email);

        List<Employee> employees = query.getResultList();

    if (!employees.isEmpty()) {
            Employee employee = employees.get(0);
            if (password.equals(employee.getPassword())) {

                redirectToExternalURL(response, "https://www.google.com");
                return true;
            }
        }

        // Authentication failed
        response.getWriter().println("Incorrect login. Please try again.");
        return false;
    }

    public void redirectToExternalURL(HttpServletResponse response, String externalURL) throws IOException {
        // Perform the redirect to the external URL
        response.sendRedirect(externalURL);
    }
}
