package com.example.asses.demo.EmployeeRepository;

import com.example.asses.demo.model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leaves,Long> {
    List<Leaves> findByEmployeeIdAndLeaveStatus(Long Id, boolean status);

}
