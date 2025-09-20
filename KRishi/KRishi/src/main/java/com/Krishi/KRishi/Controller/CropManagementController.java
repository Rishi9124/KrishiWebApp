package com.Krishi.KRishi.Controller;

import com.Krishi.KRishi.Dto.AddCropRequestDto;
import com.Krishi.KRishi.Service.CropManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getallcrops/{phoneNumber}")
    public  ResponseEntity<List<AddCropRequestDto>> getAllCrops(@PathVariable String phoneNumber){
        List<AddCropRequestDto> dto = service.getAllserCrop(phoneNumber);
        return  ResponseEntity.ok(dto);
    }
    @PutMapping("/update/{phoneNumber}")
    public ResponseEntity<AddCropRequestDto> updateCrop(
            @PathVariable String phoneNumber,
            @RequestBody AddCropRequestDto dto) {
        return ResponseEntity.ok(service.updateCropManagement(phoneNumber, dto));
    }

    @DeleteMapping("/delete/{phoneNumber}/{id}")
    public ResponseEntity<String> deleteCrop(@PathVariable String phoneNumber, @PathVariable Long id) {
        service.deleteCropManagement(phoneNumber, id);
        return ResponseEntity.ok("Crop deleted successfully");
    }


}
