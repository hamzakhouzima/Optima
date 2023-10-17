package com.optima.demo12.Http;


//import com.optima.demo12.Database.HibernateUtil;
import com.optima.demo12.Database.Employee;
import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @PersistenceUnit(unitName = "default")
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Your servlet logic

        // Forward the request to a JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPage.jsp"); //create a jsp file and send a get Request
        dispatcher.forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String date = request.getParameter("date");

        System.out.println("-----------------------------------------");

        System.out.println(username);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(password);
        System.out.println("-----------------------------------------");

//
//        Departement dep = new Departement();
//
//        dep.setDescription("azefaz");
//        dep.setDepartement_boss("fzerfz");
//        dep.setName("oierferfz");

        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setDate(date);
//        employee.setDepartment(2);


        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            response.getWriter().println("Data saved successfully!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            response.getWriter().println("Error saving data.");
        }
    }
}
