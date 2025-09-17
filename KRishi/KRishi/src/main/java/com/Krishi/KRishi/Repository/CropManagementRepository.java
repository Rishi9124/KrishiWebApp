package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.CropManagement;
import com.Krishi.KRishi.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropManagementRepository extends JpaRepository<CropManagement , Long> {

     List<CropManagement> findByProfile(Profile profile);
}
