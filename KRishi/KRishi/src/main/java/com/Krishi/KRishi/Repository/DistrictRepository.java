package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District , Long> {
    Optional<District> findByName(String name);
}


