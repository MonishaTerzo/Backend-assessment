package com.example.asses.demo.EmployeeRepository;

import com.example.asses.demo.model.Employee;
import com.example.asses.demo.model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Employeerepository extends JpaRepository<Employee,Long> {
    List<Employee> findByDobBetween(LocalDate startDate, LocalDate endDate);
    @Query("SELECT e from Employee e WHERE e.name LIKE CONCAT('%', :query, '%')")
    List<Employee> searchEmployees(String query);


    Employee findEmployeeByLeaves(Leaves leave);

}
