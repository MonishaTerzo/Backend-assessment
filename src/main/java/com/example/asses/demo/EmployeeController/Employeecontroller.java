package com.example.asses.demo.EmployeeController;
import com.example.asses.demo.EmployeeDto.Employeedto;
import com.example.asses.demo.EmployeeService.Employeeservice;
import com.example.asses.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class Employeecontroller {
    private Employeeservice employeeService;

    @Autowired
    public Employeecontroller( Employeeservice emp) {
        employeeService = emp;
    }

@GetMapping("/employee/list")
public List<Employee> findempAll() {
        Employee employee = employeeService.findAllEmployees().get(0);
    return employeeService.findAllEmployees();
}


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable long employeeId) {

        Employee theEmployee = employeeService.getEmployeeById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }


    @PostMapping("/employees/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.saveEmployee(employee);
        return dbEmployee;
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee( @PathVariable("employeeId") Long id ,@RequestBody Employee employee){
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") long id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            throw new RuntimeException("Employee id not found : "+id);
        }
        employeeService.delete(id);
        return " emp id  is - " +id;
}
    @GetMapping("/recent-birthdays")
    public ResponseEntity<List<Employee>> getRecentBirthdays() {
        List<Employee> recentBirthdays = employeeService.getRecentBirthdays();
        return ResponseEntity.ok(recentBirthdays);
    }}
