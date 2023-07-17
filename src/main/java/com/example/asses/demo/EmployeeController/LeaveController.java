package com.example.asses.demo.EmployeeController;

import com.example.asses.demo.EmployeeDto.LeaveDto;
import com.example.asses.demo.EmployeeService.LeaveService;
import com.example.asses.demo.model.Leaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/leaves")
public class LeaveController {
    private final LeaveService leaveService;

    @Autowired
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping
    public Leaves createLeave(@RequestBody Leaves leave) {

        return leaveService.createLeave(leave);
    }

    @PutMapping("/{leaveId}")
    public Leaves updateLeave(@PathVariable Long leaveId, @RequestBody Leaves leave) {
        Leaves existingLeave = leaveService.getLeaveById(leaveId);
        if (existingLeave != null) {
            leave.setId(leaveId);
            return leaveService.updateLeave(leave);
        }
        return null;
    }



    @DeleteMapping("/{leaveId}")
    public void deleteLeave(@PathVariable Long leaveId) {
        leaveService.deleteLeave(leaveId);
    }


    @GetMapping
    public List<Leaves> getAllLeaves() {
        return leaveService.getAllLeaves();
    }


    @GetMapping("/employee/{Id}/unapproved")
    public ResponseEntity<List<LeaveDto>> getUnapprovedLeavesByEmployeeId(@PathVariable Long Id) {
        List<LeaveDto> unapprovedLeaves = leaveService.getUnapprovedLeaves();
        return ResponseEntity.ok(unapprovedLeaves);
    }
    @GetMapping("/unapproved")
    public ResponseEntity<List<LeaveDto>> getUnapprovedLeaves(){
        List<LeaveDto> unapprovedLeaves = leaveService.getUnapprovedLeaves();
        return ResponseEntity.ok(unapprovedLeaves);
    }
    @PutMapping("/approve/{leaveId}")
    public ResponseEntity<Void> approveLeave(@PathVariable Long leaveId) {
        leaveService.approveLeave(leaveId);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/{leaveId}")
    public Leaves getLeaveById(@PathVariable Long leaveId) {
        return leaveService.getLeaveById(leaveId);
    }
}
