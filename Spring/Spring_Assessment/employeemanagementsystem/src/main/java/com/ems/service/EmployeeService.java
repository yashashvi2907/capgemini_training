package com.ems.service;

import com.ems.entity.Employee;
import java.util.List;

public interface EmployeeService {

    // Authentication
    Employee registerEmployee(Employee employee);
    Employee login(String email, String password);
    String logout(Integer empId);

    // CRUD
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Integer empId, Employee employee);
    String deleteEmployee(Integer empId);
    Employee getEmployeeById(Integer empId);
    List<Employee> getAllEmployees();

    // Role management
    Employee changeEmployeeRole(Integer empId, String role);
//    List<Employee> getEmployeesByRole(String role);

    // Get Employees by Role
    List<Employee> getEmployeesByRole(String role);

    // Sorting
    List<Employee> sortEmployeesBySalaryComparable();
    List<Employee> sortEmployeesByName();
    List<Employee> sortEmployeesBySalary();
    List<Employee> sortEmployeesByExperience();

    // Stream operations
    List<Employee> getEmployeesWithHighSalary(Double salary);
    List<Employee> getEmployeesByDepartment(String deptName);
    List<Employee> getEmployeesJoinedAfterYear(int year);

    Double getTotalSalaryExpense();
    Double getAverageSalary();

    List<Employee> getTopHighestPaidEmployees(int limit);

    List<Employee> getEmployeesWithExperienceGreaterThan(int years);

    List<String> getAllEmployeeNames();

    Long countEmployeesByDepartment(String deptName);

}