package com.ems.serviceimpl;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Register Employee
    @Override
    public Employee registerEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Login
    @Override
    public Employee login(String email, String password) {
        Optional<Employee> emp = repository.findByEmail(email);

        if(emp.isPresent() && emp.get().getPassword().equals(password)){
            return emp.get();
        }

        return null;
    }

    // Logout
    @Override
    public String logout(Integer empId) {
        return "Employee logged out successfully";
    }

    // Add Employee
    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Update Employee
    @Override
    public Employee updateEmployee(Integer empId, Employee employee) {

        Employee existing = repository.findById(empId).orElse(null);

        if(existing != null){
            employee.setEmpId(empId);
            return repository.save(employee);
        }

        return null;
    }

    // Delete Employee
    @Override
    public String deleteEmployee(Integer empId) {

        repository.deleteById(empId);

        return "Employee deleted successfully";
    }

    // Get Employee by ID
    @Override
    public Employee getEmployeeById(Integer empId) {

        return repository.findById(empId).orElse(null);
    }

    // Get All Employees
    @Override
    public List<Employee> getAllEmployees() {

        return repository.findAll();
    }

    // Change Role
    @Override
    public Employee changeEmployeeRole(Integer empId, String role) {

        Employee emp = repository.findById(empId).orElse(null);

        if(emp != null){
            emp.setRole(role);
            return repository.save(emp);
        }

        return null;
    }

    // Get Employees by Role
    @Override
    public List<Employee> getEmployeesByRole(String role) {

        return repository.findByRole(role);
    }

    // Comparable Sorting (Salary)
    @Override
    public List<Employee> sortEmployeesBySalaryComparable() {

        return repository.findAll()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Comparator Sorting - Name
    @Override
    public List<Employee> sortEmployeesByName() {

        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    // Comparator Sorting - Salary
    @Override
    public List<Employee> sortEmployeesBySalary() {

        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    // Comparator Sorting - Experience
    @Override
    public List<Employee> sortEmployeesByExperience() {

        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getExperienceYears))
                .collect(Collectors.toList());
    }

    // Employees with Salary Greater Than
    @Override
    public List<Employee> getEmployeesWithHighSalary(Double salary) {

        return repository.findAll()
                .stream()
                .filter(e -> e.getSalary() > salary)
                .collect(Collectors.toList());
    }

    // Employees by Department
    @Override
    public List<Employee> getEmployeesByDepartment(String deptName) {

        return repository.findByDeptName(deptName);
    }

    // Employees Joined After Year
    @Override
    public List<Employee> getEmployeesJoinedAfterYear(int year) {

        return repository.findAll()
                .stream()
                .filter(e -> e.getJoinDate() != null && e.getJoinDate().getYear() > year)
                .collect(Collectors.toList());
    }

    // Total Salary Expense
    @Override
    public Double getTotalSalaryExpense() {

        return repository.findAll()
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    // Average Salary
    @Override
    public Double getAverageSalary() {

        return repository.findAll()
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    // Top Highest Paid Employees
    @Override
    public List<Employee> getTopHighestPaidEmployees(int limit) {

        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    // Employees with Experience Greater Than
    @Override
    public List<Employee> getEmployeesWithExperienceGreaterThan(int years) {

        return repository.findAll()
                .stream()
                .filter(e -> e.getExperienceYears() > years)
                .collect(Collectors.toList());
    }

    // Get All Employee Names
    @Override
    public List<String> getAllEmployeeNames() {

        return repository.findAll()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    // Count Employees by Department
    @Override
    public Long countEmployeesByDepartment(String deptName) {

        return repository.findAll()
                .stream()
                .filter(e -> e.getDeptName().equalsIgnoreCase(deptName))
                .count();
    }
}