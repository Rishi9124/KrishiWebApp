package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.Profile;
import com.Krishi.KRishi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile ,Long> {

    Optional<Profile> findByUser(User user);
}
