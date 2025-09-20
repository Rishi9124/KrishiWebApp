package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.CropActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CropActvityRepository extends JpaRepository<CropActivity , Long> {

    Optional<CropActivity> findByActivityName(String activity);

}
