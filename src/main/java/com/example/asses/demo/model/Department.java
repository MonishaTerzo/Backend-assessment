package com.example.asses.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//for all getters and setters and for to string...
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="department")
public class Department {
    @Id
    private long id;
    private String name;
}
