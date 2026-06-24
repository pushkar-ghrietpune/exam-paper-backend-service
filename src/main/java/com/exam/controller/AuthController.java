package com.exam.controller;

import com.exam.dto.LoginRequestDTO;
import com.exam.dto.LoginResponseDTO;
import com.exam.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService) {

        this.authService = authService;

    }

    @PostMapping("/login")
    public LoginResponseDTO login(

            @RequestBody
            LoginRequestDTO request) {

        return authService.login(
                request);

    }

}
