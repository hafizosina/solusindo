package com.solusindo.id.controller;


import com.solusindo.id.dto.datanilai.DataNilaiModusDto;
import com.solusindo.id.dto.login.LoginRequest;
import com.solusindo.id.dto.login.LoginResponse;
import com.solusindo.id.dto.userlogin.SignUpRequest;
import com.solusindo.id.dto.userlogin.UserLoginDto;
import com.solusindo.id.model.DataNilaiEntity;
import com.solusindo.id.service.DataNilaiService;
import com.solusindo.id.service.LoginService;
import com.solusindo.id.service.UserLoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/datanilai")
@Tag(name = "Data Nilai")
public class DataNilaiController {

    @Autowired
    private DataNilaiService service;


    @PostMapping("/create")
    @Operation(summary = "Create", method = "POST")
    public ResponseEntity<DataNilaiEntity> create(@RequestBody DataNilaiEntity request, HttpServletRequest servletRequest) {
        DataNilaiEntity dto = service.create(request, servletRequest);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/list")
    @Operation(summary = "List", method = "GET")
    public ResponseEntity<List<DataNilaiEntity>> list(@RequestParam("name") String name, HttpServletRequest servletRequest) {
        List<DataNilaiEntity> dto = service.list(name, servletRequest);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listall")
    @Operation(summary = "List All", method = "GET")
    public ResponseEntity<List<DataNilaiEntity>> list(HttpServletRequest servletRequest) {
        List<DataNilaiEntity> dto = service.list(null, servletRequest);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/modus")
    @Operation(summary = "Modus", method = "GET")
    public ResponseEntity<DataNilaiModusDto> modus(HttpServletRequest servletRequest) {
        DataNilaiModusDto dto = service.getModus();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Create", method = "DELETED")
    public ResponseEntity<String> delete(@RequestParam("id") Long id, HttpServletRequest servletRequest) {
        service.delete(id, servletRequest);
        return ResponseEntity.ok("SUCCESS");
    }


}
