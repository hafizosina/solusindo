package com.solusindo.id.controller;

import com.solusindo.id.dto.userlogin.ChangePasswordRequest;
import com.solusindo.id.dto.userlogin.SignUpRequest;
import com.solusindo.id.dto.userlogin.UserLoginDto;
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
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/user-login")
@Tag(name = "User Login")
public class UserLoginController {

    @Autowired
    private UserLoginService service;

    @PostMapping("/signup")
    @Operation(summary = "Sign Up", method = "POST")
    public ResponseEntity<UserLoginDto> signUp(@RequestBody SignUpRequest request, HttpServletRequest servletRequest) {

        UserLoginDto dto = service.create(request, servletRequest);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/update")
    @Operation(summary = "Update", method = "POST")
    public ResponseEntity<UserLoginDto> update(@RequestBody UserLoginDto request, HttpServletRequest servletRequest) {

        UserLoginDto dto = service.update(request, servletRequest);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/change-password")
    @Operation(summary = "Change Password", method = "POST")
    public ResponseEntity<UserLoginDto> changePasswrod(@RequestBody ChangePasswordRequest request, HttpServletRequest servletRequest) {

        UserLoginDto dto = service.changepassword(request, servletRequest);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/delete")
    @Operation(summary = "Change Password", method = "POST")
    public ResponseEntity<UserLoginDto> changePasswrod(@RequestParam("username") String username, HttpServletRequest servletRequest) {

        UserLoginDto dto = service.delete(username, servletRequest);
        return ResponseEntity.ok(dto);
    }

}
