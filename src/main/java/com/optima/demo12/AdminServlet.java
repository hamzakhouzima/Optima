package com.optima.demo12;


//import com.optima.demo12.HibernateUtil;
import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
@WebServlet("/")
public class AdminServlet extends HttpServlet {

    @PersistenceUnit(unitName = "default")
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Your servlet logic

        // Forward the request to a JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/path/to/your.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("-----------------------------------------");

        System.out.println(username);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(password);
        System.out.println("-----------------------------------------");

        //   try {
        //      Thread.sleep(2000000);
        // } catch (InterruptedException e) {
        //   throw new RuntimeException(e);
        //}

        Departement dep = new Departement();

        dep.setDescription("azefaz");
        dep.setDepartement_boss("fzerfz");
        dep.setName("oierferfz");

        //Employee employee = new Employee();
        //employee.setUsername(username);
        //employee.setFirstName(firstName);
        //employee.setLastName(lastName);
        //employee.setEmail(email);
        //employee.setPassword(password);
        //employee.setDate("010101");
        //   employee.setDepartment(2);


        try {
            entityManager.getTransaction().begin();
            entityManager.persist(dep);
            entityManager.getTransaction().commit();
            response.getWriter().println("Data saved successfully!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            response.getWriter().println("Error saving data.");
        }
    }
}
