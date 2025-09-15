package com.Krishi.KRishi.Service;

import com.Krishi.KRishi.Dto.RegistrationRequestDto;
import com.Krishi.KRishi.Model.*;
import com.Krishi.KRishi.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VillageRepository villageRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private SoilRepository soilRepository;
    @Autowired
    private CropRepository cropRepository;
    @Autowired
    private FarmRepository farmRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private TalukaRepository talukaRepository;
    @Autowired
    private IrrigationTypeRepository irrigationTypeRepository;

    public Long register(RegistrationRequestDto dto){
		User user = new User();
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setIsvarified(dto.isVerified());
		user = userRepository.save(user);

		Village village = villageRepository.findByName(dto.getVillageName())
				.orElseThrow(() -> new RuntimeException("Invalid village name"));
		Taluka taluka = village.getTaluka();
		if (taluka == null || taluka.getName() == null || !taluka.getName().equalsIgnoreCase(dto.getTalukaName())) {
			throw new RuntimeException("Taluka does not match village");
		}
		District district = taluka.getDistrict();
		if (district == null || district.getName() == null || !district.getName().equalsIgnoreCase(dto.getDistrictName())) {
			throw new RuntimeException("District does not match taluka");
		}

		Profile profile = new Profile();
		profile.setName(dto.getName());
		profile.setUser(user);
		profile = profileRepository.save(profile);

		Soil soil = soilRepository.findByType(dto.getSoilType())
				.orElseThrow(() -> new RuntimeException("Invalid soil type"));

		Crop crop = cropRepository.findByName(dto.getCropName())
				.orElseThrow(() -> new RuntimeException("Invalid crop name"));

		IrrigationType irrigation = irrigationTypeRepository.findByIrrigationType(dto.getIrrigationType())
				.orElseThrow(() -> new RuntimeException("Invalid irrigation type"));

		Farm farm = new Farm();
		farm.setSoil(soil);
		farm.setSize(dto.getFarmSize());
		farm.setIrrigation(irrigation);
		farm = farmRepository.save(farm);

		user.setFarm(farm);
		user.setCrop(crop);
		user.setVillage(village);
		user = userRepository.save(user);

		return user.getId();
    }
}
