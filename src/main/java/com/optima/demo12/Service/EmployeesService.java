package com.optima.demo12.Service;

import com.optima.demo12.Database.Employee;

import java.util.List;

public interface EmployeesService {
    //add employee
    //delete employee
    //update employee
    //assign role to employee

    List<Employee> displayEmployees();
    void AddEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);

}
