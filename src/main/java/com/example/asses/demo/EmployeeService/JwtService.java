package com.example.asses.demo.EmployeeService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface JwtService {

    String extractEmail(String jwt);

    boolean isTokenValid(String jwt, UserDetails userDetails);
    String generateToken(UserDetails userDetails);
    String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    );
}