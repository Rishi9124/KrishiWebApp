package com.Krishi.KRishi.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationRequestDto {
    private String phoneNumber;
    private boolean verified;
    private String name;
    private String districtName;
    private String talukaName;
    private String villageName;
    private String farmSize;
    private String soilType;
    private String irrigationType;
    private String cropName;


}
