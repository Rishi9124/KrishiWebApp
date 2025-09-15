package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.Soil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoilRepository extends JpaRepository<Soil , Long> {
    Optional<Soil> findByType(String type);
}
