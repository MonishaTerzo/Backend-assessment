package com.example.asses.demo.EmployeeController;
import com.example.asses.demo.EmployeeDto.Employeedto;
import com.example.asses.demo.EmployeeService.Employeeservice;
import com.example.asses.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    System.out.println(employee.getJob().getPerformance());
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

    @PutMapping("/employees/{employeeId}/update")
    public boolean updateEmployeeInfo(@RequestBody @PathVariable("employeeId") Employee employee){
        employeeService.saveEmployee(employee);
        return true;
    }

    @DeleteMapping("/employees/delete/{employeeId}")
    public void  deleteEmployee(@PathVariable long employeeId) {
        Employee tempEmployee = employeeService.getEmployeeById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.delete(employeeId);
    }
}
