package com.example.asses.demo.EmployeeService.impl;

import com.example.asses.demo.EmployeeRepository.LeaveRepository;
import com.example.asses.demo.EmployeeService.LeaveService;
import com.example.asses.demo.model.Leaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class LeaveServiceImpl implements LeaveService {


        private final LeaveRepository leaveRepository;

        @Autowired
        public LeaveServiceImpl(LeaveRepository leaveRepository) {
            this.leaveRepository = leaveRepository;
        }

        public Leaves createLeave(Leaves leave) {
            return leaveRepository.save(leave);
        }

        public Leaves updateLeave(Leaves leave) {
            return leaveRepository.save(leave);
        }

        public void deleteLeave(Long leaveId) {
            leaveRepository.deleteById(leaveId);
        }

        public List<Leaves> getAllLeaves() {
            return leaveRepository.findAll();
        }

        public Leaves getLeaveById(Long leaveId) {
            return leaveRepository.findById(leaveId).orElse(null);
        }
    public Leaves approveLeave(Long ids) {
    Optional<Leaves> optionalLeaveApplication =leaveRepository.findById(ids);
        if (optionalLeaveApplication.isPresent()) {
        Leaves leaveApplication = optionalLeaveApplication.get();
        leaveApplication.setApproved(true);
        return leaveRepository.save(leaveApplication);
    } else {
        throw new IllegalArgumentException("Leave application not found.");
    }
}
    }
