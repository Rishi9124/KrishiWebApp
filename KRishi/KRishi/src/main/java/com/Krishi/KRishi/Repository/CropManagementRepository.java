package com.Krishi.KRishi.Repository;

import com.Krishi.KRishi.Model.CropManagement;
import com.Krishi.KRishi.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CropManagementRepository extends JpaRepository<CropManagement , Long> {

     List<CropManagement> findByProfile(Profile profile);

     @Query(value = "SELECT cm.cropmanagementidp, c.cropname, s.seasonname, f.farmsize, so.type AS soil_type, u.cropsnowingdate " +
             "FROM tbcropmanagement cm " +
             "JOIN tbprofile p ON cm.profileidf = p.profileidp " +
             "JOIN tbuser u ON p.useridf = u.useridp " +
             "JOIN tbcrop c ON cm.cropidf = c.cropidp " +
             "JOIN tbseoson s ON cm.seasonidf = s.seasonidp " +
             "JOIN tbfarm f ON cm.farmidf = f.farmidp " +
             "LEFT JOIN tbsoil so ON so.soilidp = f.soilidf " +
             "WHERE u.phonenumber = :phoneNumber", nativeQuery = true)
     List<Object[]> findAllCropsByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
