package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.Taluka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TalukaRepository extends JpaRepository<Taluka , Long> {
    Optional<Taluka> findByName(String name);
}


