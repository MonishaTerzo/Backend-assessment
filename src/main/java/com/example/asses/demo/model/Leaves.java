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

@Table(name="leaves")
@Entity
public class Leaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private LocalDate startDate;

    private LocalDate endDate;
    private boolean approved;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Employee employee;

}
