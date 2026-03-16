package com.ems.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee implements Comparable<Employee> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    private Double salary;
    private String address;
    private String deptName;
    private String role;
    private String password;

    private Integer age;
    private String gender;

    private Boolean active;

    private Double bonus;

    private Integer experienceYears;

    private String designation;

    public Employee() {}

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDateTime getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDateTime joinDate) { this.joinDate = joinDate; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Double getBonus() { return bonus; }
    public void setBonus(Double bonus) { this.bonus = bonus; }

    public Integer getExperienceYears() { return experienceYears; }
    public void setExperienceYears(Integer experienceYears) { this.experienceYears = experienceYears; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    @Override
    public int compareTo(Employee e) {
        return this.salary.compareTo(e.salary);
    }
}