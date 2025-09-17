package com.Krishi.KRishi.Controller;

import com.Krishi.KRishi.Dto.AddCropRequestDto;
import com.Krishi.KRishi.Service.CropManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crop")
public class CropManagementController {
    @Autowired
    private CropManagementService service;

    CropManagementController(CropManagementService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCrop(@RequestBody AddCropRequestDto dto){
        Long cropManagementId = service.addCrop(dto);
        return ResponseEntity.ok("Crop added successfully with ID: " + cropManagementId);
    }
}
