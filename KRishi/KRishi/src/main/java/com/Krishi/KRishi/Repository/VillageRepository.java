package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.Village;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VillageRepository extends JpaRepository<Village ,Long> {
    Optional<Village> findByName(String name);
}
