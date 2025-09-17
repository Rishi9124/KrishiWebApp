package com.Krishi.KRishi.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCropRequestDto {

    private String cropName;
    private String area;
    private String sowingDate;
    private  String seasonName;
    private String soiltype;
    private String phonenumber ;

}
