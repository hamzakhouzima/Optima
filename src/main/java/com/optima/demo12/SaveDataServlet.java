package com.optima.demo12;// SaveDataServlet.java

//import com.optima.demo12.HibernateUtil;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;

    @WebServlet("/SaveDataServlet")
    public class SaveDataServlet extends HttpServlet {
        @PersistenceContext(unitName = "default")
        private EntityManager entityManager;

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            try {
                // Begin the transaction
                entityManager.getTransaction().begin();

                // Create a new Employee
                Employee employee = new Employee();
                employee.setUsername(username);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setPassword(password);
              //  employee.setDepartment();
                // Set other employee properties

                // Retrieve and set the Role from the database
                Role role = entityManager.find(Role.class, 1); // Replace roleId with the actual role ID
                employee.setRole(role);

                // Persist the Employee
                entityManager.persist(employee);

                // Commit the transaction
                entityManager.getTransaction().commit();

                response.getWriter().println("Data saved successfully!");
            } catch (Exception e) {
                // Rollback the transaction in case of an error
                entityManager.getTransaction().rollback();
                e.printStackTrace();
                response.getWriter().println("Error saving data.");
            }
        }
    }


