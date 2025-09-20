package com.Krishi.KRishi.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCropRequestDto {
    private int id ;
    private String cropName;
    private String area;
    private String sowingDate;
    private  String seasonName;
    private String soiltype;
    private String phonenumber ;

    public AddCropRequestDto(Long id, String name, String name1, String size, String type, String s) {
    }
}
