package com.example.asses.demo.EmployeeRepository;

import com.example.asses.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepository extends JpaRepository<Employee,Long> {
}
