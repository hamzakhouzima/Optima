package com.optima.demo12.Http;

import com.optima.demo12.Database.Employee;
import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/demo12_war_exploded/MyLoginServlet")
public class LoginServlet extends HttpServlet {
//    @PersistenceContext(unitName = "default")

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the login page (login.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isUserValid(email, password,response,request)) {
            System.out.println("Correct");

        } else {
            System.out.println("Incorrect");

        }

    }

    private boolean isUserValid(String email, String password, HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
        // Query the database for an employee with the specified email
        HttpSession session = request.getSession();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String jpql = "SELECT e FROM Employee e WHERE e.email = :email";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("email", email);

        List<Employee> employees = query.getResultList();

        if (!employees.isEmpty()) {
            Employee employee = employees.get(0);
            if (password.equals(employee.getPassword())) {
//                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/demo12_war_exploded/admin/");
//                requestDispatcher.forward(request, response);
                redirectToExternalURL(response, "/demo12_war_exploded/admin");
                //redirectToExternalURL(response, "https://google.com");
                session.setAttribute("id", employee.getId());
                return true;
            }
        }

        // auth failed
        redirectToExternalURL(response, "/demo12_war_exploded/LoginServlet");



        return false;
    }

    public void redirectToExternalURL(HttpServletResponse response, String externalURL) throws IOException {
        //  redirect to the external URL
        response.sendRedirect(externalURL);

    }
}
