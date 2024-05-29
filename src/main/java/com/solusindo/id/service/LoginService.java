package com.solusindo.id.service;

import com.solusindo.id.dto.login.LoginRequest;
import com.solusindo.id.dto.login.LoginResponse;
import com.solusindo.id.exception.ProcessException;
import com.solusindo.id.model.UserLoginEntity;
import com.solusindo.id.repository.UserLoginRepository;
import com.solusindo.id.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LoginService {

    @Autowired
    private UserLoginRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request, HttpServletRequest servletRequest){
        UserLoginEntity userLogin = repository.findByUsernameAndDeletedFalse(request.getUsername())
                .orElseThrow(() -> new ProcessException("Wrong Username"));

        String token = jwtUtil.generateToken(userLogin.getUsername());
        return LoginResponse.builder()
                .username(userLogin.getUsername())
                .token(token)
                .build();
    }
}
