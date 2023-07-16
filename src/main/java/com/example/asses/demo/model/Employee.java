package com.example.asses.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Data//for all getters and setters and for to string...
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoUrl;
    private String name;
    private LocalDateTime joining_date;
    private String employee_status ;
    private String employee_type;
    private String jobtitle;
    private String performance;
    private String gender;
    private String bloodgroup;
    private String fathername;
    private String mothername;
    private String phoneno;
    private String emailid;
    private String salary;
    private String address;
    public LocalDate dob;


    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

//    @OneToOne
//    @JoinColumn(name = "job_id")
//    private Job job;
//
//    @OneToOne
//    @JoinColumn(name = "personal_id")
//    private Personal personal;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Leaves> leaves = new ArrayList<>();
}





