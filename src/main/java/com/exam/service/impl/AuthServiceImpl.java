package com.exam.service.impl;

import com.exam.dto.LoginRequestDTO;
import com.exam.dto.LoginResponseDTO;

import com.exam.security.JwtService;
import com.exam.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthServiceImpl implements AuthService {
    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        if (
                adminUsername.equals(
                        request.getUsername())
                        &&
                        passwordEncoder.matches(
                                request.getPassword(),
                                adminPassword)
        )
        {
            String token =
                    jwtService.generateToken(
                            request.getUsername());

            return new LoginResponseDTO(
                    token,
                    "ROLE_ADMIN");
        }

        throw new RuntimeException( "Invalid username or password");
    }
}
