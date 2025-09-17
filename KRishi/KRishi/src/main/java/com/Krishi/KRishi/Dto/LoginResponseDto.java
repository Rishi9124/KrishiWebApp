package com.Krishi.KRishi.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {

    public LoginResponseDto(String message) {
        this.message = message;
    }

    private String message ;
}
