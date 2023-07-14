package com.example.asses.demo.EmployeeRepository;

import com.example.asses.demo.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal,Long> {

}
