package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.LogActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogActivityRepository  extends JpaRepository<LogActivity , Long> {
    List<LogActivity> findByProfileId(Long profileId);
}
