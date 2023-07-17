package com.example.asses.demo.EmployeeDto;

import com.example.asses.demo.model.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

    public class LeaveDto {

        private Long id;
        private String reason;
        private LocalDate startDate;

        private LocalDate endDate;

        private boolean leaveStatus;


        private String employee;
    }


