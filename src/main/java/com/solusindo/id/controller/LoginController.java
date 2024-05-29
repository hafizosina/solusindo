package com.solusindo.id.controller;


import com.solusindo.id.dto.login.LoginRequest;
import com.solusindo.id.dto.login.LoginResponse;
import com.solusindo.id.dto.userlogin.SignUpRequest;
import com.solusindo.id.dto.userlogin.UserLoginDto;
import com.solusindo.id.service.LoginService;
import com.solusindo.id.service.UserLoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
@Tag(name = "Login")
public class LoginController {


    @Autowired
    private LoginService service;

    @Autowired
    private UserLoginService userService;


    @PostMapping("/username")
    @Operation(summary = "Login", method = "POST")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request, HttpServletRequest servletRequest) {

        LoginResponse dto = service.login(request, servletRequest);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/signup")
    @Operation(summary = "Sign Up", method = "POST")
    public ResponseEntity<UserLoginDto> signUp(@RequestBody SignUpRequest request, HttpServletRequest servletRequest) {

        UserLoginDto dto = userService.create(request, servletRequest);
        return ResponseEntity.ok(dto);
    }
}
