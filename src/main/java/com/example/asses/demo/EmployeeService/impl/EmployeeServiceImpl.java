package com.example.asses.demo.EmployeeService.impl;
import com.example.asses.demo.EmployeeDto.Employeedto;
import com.example.asses.demo.EmployeeRepository.Employeerepository;
import com.example.asses.demo.EmployeeService.Employeeservice;
import com.example.asses.demo.model.Employee;
import com.example.asses.demo.model.Leaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements Employeeservice {

   private Employeerepository employeerepository;
   @Autowired
   public EmployeeServiceImpl(Employeerepository employeerepository) {
        this.employeerepository = employeerepository;
    }
    @Override
    public List<Employee> findAllEmployees() {
            return  employeerepository.findAll();
//            return employees.stream().map((employee) -> maptoemployeedto(employee)).collect(Collectors.toList())
        }
    @Override
    public List<Employee> searchEmployees(String query) {
        List<Employee> employees = employeerepository.searchEmployees(query);
        return employees;
    }
    @Override
    public Employee findEmployeeByLeave(Leaves leaves) {
        return employeerepository.findEmployeeByLeaves(leaves);
    }

    @Override
    public Employee getEmployeeById(Long Id) {
        Employee emp=employeerepository.findById(Id).get();
        return emp;
    }

    @Override
    public void updateEmployee(Employee employee) {

        employeerepository.save(employee);
    }


    @Override
    public Employee saveEmployee(Employee emp) {
        return employeerepository.save(emp);
    }

    @Override
    public void delete(Long Id) {
        employeerepository.deleteById(Id);

    }
    @Override
    public List<Employee> getRecentBirthdays() {
        LocalDate currentDate = LocalDate.now();
        LocalDate sevenDaysAgo = currentDate.plusDays(7);
        return employeerepository.findByDobBetween(sevenDaysAgo, currentDate);
    }


    public Employee maptoemployee(Employeedto emp) {
        Employee emps = Employee.builder()
                .id(emp.getId())
                .photoUrl(emp.getPhotoUrl())
                .name(emp.getName())
                .build();
        return emps;
    }

    public Employeedto maptoemployeedto(Employee employee) {
        Employeedto dtos = Employeedto.builder()
                .photoUrl(employee.getPhotoUrl())
                .id(employee.getId())
                .name(employee.getName())
                .build();
        return dtos;
    }
}
