package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.IrrigationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IrrigationTypeRepository extends JpaRepository<IrrigationType , Long> {
    Optional<IrrigationType> findByIrrigationType(String irrigationType);
}


