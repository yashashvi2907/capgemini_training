package com.ems.controller;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Register Employee
    @PostMapping("/register")
    public String registerEmployee(@RequestBody Employee employee){
        service.registerEmployee(employee);
        return "Employee registered successfully";
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody Employee employee){

        Employee emp = service.login(employee.getEmail(), employee.getPassword());

        if(emp != null){
            return "Login successful for employee: " + emp.getName();
        }

        return "Invalid email or password";
    }

    // Logout
    @PostMapping("/logout/{id}")
    public String logout(@PathVariable Integer id){
        service.logout(id);
        return "Employee logged out successfully";
    }

    // Add Employee
    @PostMapping
    public String addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
        return "Employee added successfully";
    }

    // Get All Employees
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Integer id,
                                 @RequestBody Employee employee){

        service.updateEmployee(id,employee);
        return "Employee updated successfully";
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    // Change Role
    @PutMapping("/role/{id}")
    public String changeRole(@PathVariable Integer id,
                             @RequestBody Employee employee){

        service.changeEmployeeRole(id, employee.getRole());

        return "Employee role updated successfully";
    }
    // sorting using comparable
    @GetMapping("/sort/salary-comparable")
    public List<Employee> sortEmployeesBySalaryComparable(){
        return service.sortEmployeesBySalaryComparable();
    }

    //sorting using comparator -- name
    @GetMapping("/sort/name")
    public List<Employee> sortEmployeesByName(){
        return service.sortEmployeesByName();
    }
    // sorting using comparator -- salary
    @GetMapping("/sort/salary")
    public List<Employee> sortEmployeesBySalary(){
        return service.sortEmployeesBySalary();
    }
    // sorting using comparator -- experience
    @GetMapping("/sort/experience")
    public List<Employee> sortEmployeesByExperience(){
        return service.sortEmployeesByExperience();
    }

    @GetMapping("/salary-greater")
    public List<Employee> getEmployeesWithHighSalary(@RequestParam Double salary){
        return service.getEmployeesWithHighSalary(salary);
    }

    @GetMapping("/department")
    public List<Employee> getEmployeesByDepartment(@RequestParam String deptName){
        return service.getEmployeesByDepartment(deptName);
    }

    @GetMapping("/joined-after")
    public List<Employee> getEmployeesJoinedAfter(@RequestParam int year){
        return service.getEmployeesJoinedAfterYear(year);
    }

    @GetMapping("/total-salary")
    public Double getTotalSalaryExpense(){
        return service.getTotalSalaryExpense();
    }

    @GetMapping("/average-salary")
    public Double getAverageSalary(){
        return service.getAverageSalary();
    }

    @GetMapping("/top-paid")
    public List<Employee> getTopHighestPaidEmployees(@RequestParam int limit){
        return service.getTopHighestPaidEmployees(limit);
    }

    @GetMapping("/experience-greater")
    public List<Employee> getEmployeesWithExperienceGreaterThan(@RequestParam int years){
        return service.getEmployeesWithExperienceGreaterThan(years);
    }

    @GetMapping("/names")
    public List<String> getAllEmployeeNames(){
        return service.getAllEmployeeNames();
    }

    @GetMapping("/count-department")
    public Long countEmployeesByDepartment(@RequestParam String deptName){
        return service.countEmployeesByDepartment(deptName);
    }



}