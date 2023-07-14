package com.example.asses.demo.EmployeeService;

import com.example.asses.demo.model.Leaves;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LeaveService {
         Leaves createLeave(Leaves leave) ;
        Leaves updateLeave(Leaves leave);
       void deleteLeave(Long leaveId);
         List<Leaves> getAllLeaves();
      Leaves getLeaveById(Long leaveId);
    }

