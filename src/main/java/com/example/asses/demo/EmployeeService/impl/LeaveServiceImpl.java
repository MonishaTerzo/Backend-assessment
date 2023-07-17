package com.example.asses.demo.EmployeeService.impl;

import com.example.asses.demo.EmployeeDto.LeaveDto;
import com.example.asses.demo.EmployeeRepository.LeaveRepository;
import com.example.asses.demo.EmployeeService.LeaveService;
import com.example.asses.demo.model.Leaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<LeaveDto> getUnapprovedLeaves() {
        List<Leaves> leavess = leaveRepository.findLeavesByLeaveStatus(false);
        List<LeaveDto> leaveDtos = leavess.stream().map(leaves -> mapToLeaveDto(leaves)).collect(Collectors.toList());
        return leaveDtos;
    }

    private LeaveDto mapToLeaveDto(Leaves leaves) {
            LeaveDto leaveDto=LeaveDto.builder()
                    .leaveStatus(leaves.isLeaveStatus())
                    .endDate(leaves.getStartDate())
                    .startDate(leaves.getEndDate())
                    .reason(leaves.getReason())
                    .employee(leaves.getEmployee().getName())
                    .build();
            return leaveDto;
    }
    public void approveLeave(Long leaveId) {

       Leaves leave= leaveRepository.findById(leaveId).orElse(null);
        leave.setLeaveStatus(true);
        leaveRepository.save(leave);
    }

}
