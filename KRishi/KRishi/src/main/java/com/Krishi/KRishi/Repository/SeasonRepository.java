package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season , Long> {

    Optional<Season> findByName(String name);
}
