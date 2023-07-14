package com.example.asses.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data//for all getters and setters and for to string...
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime joining_date;
    private String employee_status ;
    private String employee_type;
    private String jobtitle;
    private String performance;

    @OneToOne(mappedBy = "job")
    @JsonBackReference

    private Employee employee;
}





