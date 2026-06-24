package com.exam.service;

import com.exam.dto.LoginRequestDTO;
import com.exam.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(
            LoginRequestDTO request);
}
