package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
