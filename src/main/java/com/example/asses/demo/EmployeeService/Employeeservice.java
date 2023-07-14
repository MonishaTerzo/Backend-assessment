package com.example.asses.demo.EmployeeService;

import com.example.asses.demo.EmployeeDto.Employeedto;
import com.example.asses.demo.model.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public interface Employeeservice {

    List<Employee> findAllEmployees();
    Employee getEmployeeById(Long Id);
    void updateEmployee(Employeedto emp);
      Employee saveEmployee(Employee emp);
    void delete(Long Id);


}
