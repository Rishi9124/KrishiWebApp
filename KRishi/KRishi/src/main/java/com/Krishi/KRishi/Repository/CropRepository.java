package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CropRepository extends JpaRepository<Crop ,Long> {
    Optional<Crop> findByName(String name);
}
