package com.example.asses.demo.EmployeeService;

import com.example.asses.demo.EmployeeDto.AuthDto;
import com.example.asses.demo.EmployeeDto.LoginDto;
import com.example.asses.demo.EmployeeDto.UserDto;
import com.example.asses.demo.EmployeeService.JwtService;
import com.example.asses.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

@Service
public class LoginService {
    JwtService jwtService;
    AuthenticationManager authenticationManager;
    private com.example.asses.demo.EmployeeRepository.UserRepository userRepository;

    @Autowired
    public LoginService(JwtService jwtService, AuthenticationManager authenticationManager, com.example.asses.demo.EmployeeRepository.UserRepository userRepository)
 {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }



    public AuthDto authenticate(LoginDto loginDto) {
        System.out.println("Hola");
        System.out.println(loginDto.toString());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));

        System.out.println("Hello");
        Users users = userRepository.findByEmail(loginDto.getEmail());
        System.out.println(users.toString());
        System.out.println(jwtService.generateToken((new UserDto(users))));
        AuthDto authenticationDto = AuthDto.builder()
                .jwt(jwtService.generateToken((new UserDto(users))))
                .build();
        return authenticationDto;
    }
}