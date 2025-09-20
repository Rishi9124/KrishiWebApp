package com.Krishi.KRishi.Service;

import com.Krishi.KRishi.Dto.AddCropRequestDto;
import com.Krishi.KRishi.Model.*;
import com.Krishi.KRishi.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private ProfileRepository profileRepository;


    public Long addCrop(AddCropRequestDto dto){

        User user = userRepository.findByPhoneNumber(dto.getPhonenumber())
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
        user.setDate(dto.getSowingDate());

//        try {Date parsedDate = parseDate(String.valueOf(dto.getSowingDate()));
//            Date date = new SimpleDateFormat("dd-MM-yyyy ").parse(dto.getSowingDate());
//            user.setDate(parsedDate);
//        } catch (ParseException e) {
//            throw new RuntimeException("Invalid date format, expected dd-MM-yyyy");
//        }

         cropManagement = cropManagementRepository.save(cropManagement);

        return cropManagement.getId();
    }

//    public List<AddCropRequestDto> getAllserCrop(String phoneNumber){
//        User user = userRepository.findByPhoneNumber((phoneNumber))
//                .orElseThrow(()-> new RuntimeException("no user found."));
//
//        Profile profile = profileRepository.findByUser(user)
//                .orElseThrow(()-> new RuntimeException("no profile found for user"));
//
//        List<CropManagement> cropManagementList = cropManagementRepository.findByProfile(profile);
//
//        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
//        return  cropManagementList.stream().map(cropMgmt  ->
//              new AddCropRequestDto( cropMgmt.getId(),
//                      cropMgmt.getCrop().getName(),
//                      cropMgmt.getSeason().getName(),
//                      cropMgmt.getFarm().getSize(),
//                      cropMgmt.getFarm().getSoil().getType(),
//                      user.getDate())
//
//
//        ).collect(Collectors.toList());


//    }
public List<AddCropRequestDto> getAllserCrop(String phoneNumber) {

    // Optional: check if user exists (for better error handling)
//    User user = userRepository.findByPhoneNumber(phoneNumber.trim())
//            .orElseThrow(() -> new RuntimeException("No user found."));

    // Call the native query
    List<Object[]> results = cropManagementRepository.findAllCropsByPhoneNumber(phoneNumber.trim());

    // Map each Object[] row to your DTO
    return results.stream().map(row -> {
        Long cropManagementId = ((Number) row[0]).longValue();
        String cropName = (String) row[1];
        String seasonName = (String) row[2];
        String farmSize = (String) row[3];
        String soilType = (String) row[4];
        String sowingDate = (String) row[5];

        // Format date as string
//        String sowingDateStr = sowingDate != null ? new SimpleDateFormat("dd-MM-yyyy").format(sowingDate) : null;

        return new AddCropRequestDto(
                cropManagementId,
                cropName,
                seasonName,
                farmSize,
                soilType,
                sowingDate
        );
    }).collect(Collectors.toList());
}

    public AddCropRequestDto updateCropManagement(String phoneNumber, AddCropRequestDto dto) {

        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Profile profile = profileRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Profile not found"));


        CropManagement cropManagement = cropManagementRepository.findById((long) dto.getId())
                .orElseThrow(() -> new RuntimeException("Crop record not found"));

        if (!cropManagement.getProfile().getId().equals(profile.getId())) {
            throw new RuntimeException("This crop does not belong to the logged-in user");
        }


        Crop crop = cropRepository.findByName(dto.getCropName())
                .orElseThrow(() -> new RuntimeException("Invalid crop name"));
        Season season = seasonRepository.findByName(dto.getSeasonName())
                .orElseThrow(() -> new RuntimeException("Invalid season name"));

        cropManagement.setCrop(crop);
        cropManagement.setSeason(season);
        cropManagement.getFarm().setSize(dto.getArea());
        cropManagement.getFarm().getSoil().setType(dto.getSoiltype());
        cropManagement.getFarm().getProfile().getUser().setDate(dto.getSowingDate());

//        try { Date parsedDate = parseDate(String.valueOf(dto.getSowingDate()));
//            cropManagement.getFarm().getProfile().getUser()
//                    .setDate(parsedDate);
//        } catch (Exception e) {
//            throw new RuntimeException("Invalid date format");
//        }


        CropManagement updated = cropManagementRepository.save(cropManagement);

        return new AddCropRequestDto(
                updated.getId(),
                updated.getCrop().getName(),
                updated.getSeason().getName(),
                updated.getFarm().getSize(),
                updated.getFarm().getSoil().getType(),
                dto.getSowingDate()
        );
    }

    public void deleteCropManagement(String phoneNumber, Long cropManagementId) {

        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Profile profile = profileRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Profile not found"));


        CropManagement cropManagement = cropManagementRepository.findById(cropManagementId)
                .orElseThrow(() -> new RuntimeException("Crop record not found"));

        if (!cropManagement.getProfile().getId().equals(profile.getId())) {
            throw new RuntimeException("This crop does not belong to the logged-in user");
        }

        cropManagementRepository.delete(cropManagement);
    }



}
