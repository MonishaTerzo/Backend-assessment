package com.example.asses.demo.EmployeeRepository;

import com.example.asses.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Employeerepository extends JpaRepository<Employee,Long> {
    List<Employee> findByDobBetween(LocalDate startDate, LocalDate endDate);
}
