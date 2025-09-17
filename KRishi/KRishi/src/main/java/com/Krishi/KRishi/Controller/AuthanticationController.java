package com.Krishi.KRishi.Controller;

import com.Krishi.KRishi.Dto.LoginRequestDto;
import com.Krishi.KRishi.Dto.LoginResponseDto;
import com.Krishi.KRishi.Service.AuthanticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthanticationController {
@Autowired
    private AuthanticationService authanticationService;

    private AuthanticationController(AuthanticationService authanticationService){
        this.authanticationService = authanticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto response = authanticationService.login(loginRequestDto);
        return ResponseEntity.ok(response);
    }





}
