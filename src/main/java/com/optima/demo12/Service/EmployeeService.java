package com.optima.demo12.Service;

import com.optima.demo12.Database.Employee;
import jakarta.persistence.*;

import java.util.List;

public class EmployeeService implements EmployeesService{


    @PersistenceUnit(unitName = "default")
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    EmployeeService employeeList = new EmployeeService();



    @Override
    public List<Employee> displayEmployees() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String SelectQuery = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(SelectQuery, Employee.class);
      //  query.setParameter("id", ById);

        List<Employee> employees = query.getResultList();



        return employees;
    }

    @Override
    public void AddEmployee(Employee employee ) {


        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
//            response.getWriter().println("Data saved successfully!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
//            response.getWriter().println("Error saving data.");
        }
    }
}
