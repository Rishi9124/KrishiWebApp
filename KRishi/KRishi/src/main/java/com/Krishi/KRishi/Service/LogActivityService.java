package com.Krishi.KRishi.Service;

import com.Krishi.KRishi.Dto.LogActivityRequestDto;
import com.Krishi.KRishi.Model.Crop;
import com.Krishi.KRishi.Model.CropActivity;
import com.Krishi.KRishi.Model.LogActivity;
import com.Krishi.KRishi.Model.Profile;
import com.Krishi.KRishi.Repository.CropActvityRepository;
import com.Krishi.KRishi.Repository.CropRepository;
import com.Krishi.KRishi.Repository.LogActivityRepository;
import com.Krishi.KRishi.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LogActivityService {

    @Autowired
    private LogActivityRepository logActivityRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private CropActvityRepository cropActvityRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public void addLogActivity(LogActivityRequestDto dto) throws Exception {
        LogActivity logActivity = new LogActivity();


//        Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dto.getDate());
        logActivity.setDate(dto.getDate());


        Crop crop = cropRepository.findByName(dto.getCropName())
                .orElseThrow(() -> new RuntimeException("Invalid crop name: " + dto.getCropName()));
        logActivity.setCrop(crop);


        CropActivity activity = cropActvityRepository.findByActivityName(dto.getActivityType())
                .orElseThrow(() -> new RuntimeException("Invalid activity type: " + dto.getActivityType()));
        logActivity.setCropActivity(activity);

        Profile profile = profileRepository.findById(dto.getProfileId())
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + dto.getProfileId()));
        logActivity.setProfile(profile);

        logActivityRepository.save(logActivity);
    }

    public List<LogActivity> getLogActivitiesByProfile(Long profileId) {
        return logActivityRepository.findByProfileId(profileId);
    }
}

