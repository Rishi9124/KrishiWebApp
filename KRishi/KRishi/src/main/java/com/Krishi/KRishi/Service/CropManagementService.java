package com.Krishi.KRishi.Service;

import com.Krishi.KRishi.Dto.AddCropRequestDto;
import com.Krishi.KRishi.Model.Crop;
import com.Krishi.KRishi.Model.CropManagement;
import com.Krishi.KRishi.Model.Season;
import com.Krishi.KRishi.Model.User;
import com.Krishi.KRishi.Repository.CropManagementRepository;
import com.Krishi.KRishi.Repository.CropRepository;
import com.Krishi.KRishi.Repository.SeasonRepository;
import com.Krishi.KRishi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CropManagementService {
    @Autowired
    private CropRepository cropRepository;
    @Autowired
    private SeasonRepository seasonRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CropManagementRepository cropManagementRepository;


    public Long addCrop(AddCropRequestDto dto){

        User user = userRepository.findByMobileNumber(dto.getPhonenumber())
                .orElseThrow(()-> new RuntimeException("User not find ."));

        Crop crop = cropRepository.findByName(dto.getCropName())
                .orElseThrow(()-> new RuntimeException("no crop found"));

        Season season = seasonRepository.findByName(dto.getSeasonName())
                .orElseThrow(() -> new RuntimeException("Invalid season name"));

        CropManagement cropManagement = new CropManagement();
        cropManagement.setCrop(crop);
        cropManagement.setFarm(user.getFarm());
        cropManagement.setSeason(season);
        cropManagement.setProfile(user.getFarm().getProfile());

        user.getFarm().setSize(dto.getArea());

        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dto.getSowingDate());
            user.setDate(date);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format, expected dd-MM-yyyy HH:mm");
        }

         cropManagement = cropManagementRepository.save(cropManagement);

        return cropManagement.getId();
    }


}
