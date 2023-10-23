package com.optima.demo12.Service;

import com.optima.demo12.Database.Employee;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

public class EmployeeService implements EmployeesService {

    @PersistenceContext(unitName = "default")
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
    @Transactional
    @Override
    public List<Employee> displayEmployees() {
        String selectQuery = "SELECT e FROM Employee  e";
        TypedQuery<Employee> query = entityManager.createQuery(selectQuery, Employee.class);
        List<Employee> employees = query.getResultList();
//returned to .jsp
        return employees;
    }

    @Transactional
    @Override
    public void AddEmployee(Employee employee) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    @Override
    public Employee getEmployeeById(int employeeId) {
        EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();
        return em.find(Employee.class, employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();

        try {
            em.getTransaction().begin();
            if (em.contains(employee)) {
                em.remove(employee);
            } else {
                Employee managedEmployee = em.find(Employee.class, employee.getId());
                if (managedEmployee != null) {
                    em.remove(managedEmployee);
                } else {
                    // Handle the case where the employee doesn't exist
                    // You can throw an exception, log the error, or take other actions as needed
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            // Handle any exceptions that may occur during the delete operation
            e.printStackTrace(); // You can log the error for debugging purposes
            // You can also throw a custom exception or handle the error in a specific way
        } finally {
            em.close();
        }
    }
}
