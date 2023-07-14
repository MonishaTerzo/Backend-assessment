package com.example.asses.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data//for all getters and setters and for to string...
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="personal_details")
public class Personal{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;
    private String bloodgroup;
    private String fathername;
    private String mothername;
    private String phoneno;
    private String emailid;
    private String salary;
    private String address;
@JsonBackReference
    @OneToOne(mappedBy = "personal")
    private Employee employee;
}