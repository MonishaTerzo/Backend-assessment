package com.example.asses.demo.EmployeeDto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobDto {

    private Long id;
    private LocalDateTime joining_date;
    private String employee_status ;
    private String employee_type;
    private String jobtitle;
    private String performance;

}