package com.ems.repository;

import com.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByRole(String role);

    List<Employee> findByDeptName(String deptName);

}