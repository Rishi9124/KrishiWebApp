package com.Krishi.KRishi.Controller;

import com.Krishi.KRishi.Dto.RegistrationRequestDto;
import com.Krishi.KRishi.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RegistrationController {


    @Autowired
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService service){

        this.registrationService = service;
    }

    @PostMapping("/api/registration")
    public ResponseEntity<?> register(@RequestBody RegistrationRequestDto dto){
        Long userId = registrationService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }
}
