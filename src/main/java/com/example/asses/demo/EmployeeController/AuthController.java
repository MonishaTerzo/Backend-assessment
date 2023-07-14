package com.example.asses.demo.EmployeeController;

import com.example.asses.demo.EmployeeDto.AuthDto;
import com.example.asses.demo.EmployeeDto.LoginDto;
import com.example.asses.demo.EmployeeService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RequestMapping()
@CrossOrigin("*")
@RestController
public class AuthController {
    LoginService loginService;

    @Autowired
    public AuthController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping("/login")
    public AuthDto login(@RequestBody LoginDto loginDto){
        AuthDto responseDto = loginService.authenticate(loginDto);
        return responseDto;
    }

}