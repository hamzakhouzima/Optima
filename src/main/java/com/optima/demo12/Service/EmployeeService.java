package com.optima.demo12.Service;

import com.optima.demo12.Database.Employee;

import jakarta.persistence.*;

import java.util.List;

public class EmployeeService implements EmployeesService {

    @PersistenceContext(unitName = "default")
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();

    @Override
    public List<Employee> displayEmployees() {
        String selectQuery = "SELECT e FROM Employee  e";
        TypedQuery<Employee> query = entityManager.createQuery(selectQuery, Employee.class);
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public void AddEmployee(Employee employee) {
        try {
            entityManager.persist(employee);
        } catch (Exception e) {
            // Handle the exception or propagate it to the caller for handling.
            e.printStackTrace();
        }
    }
}
