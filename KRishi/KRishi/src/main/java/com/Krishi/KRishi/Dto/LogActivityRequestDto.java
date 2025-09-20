package com.Krishi.KRishi.Dto;

import lombok.Data;

@Data
public class LogActivityRequestDto {
    private String cropName;
    private String activityType;
    private String date;
    private Long profileId;
}
