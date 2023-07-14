package com.example.asses.demo.EmployeeDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;



@Data//for all getters and setters and for to string...
@Builder
public class Employeedto {




        private String photoUrl;
        private Long id;
        private String name;






}




