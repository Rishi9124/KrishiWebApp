package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserIDP")
    Long id ;

    @Column(name = "phoneNumber")
    String phoneNumber;

    @Column(name = "isVarified")
    boolean isvarified ;

    @ManyToOne
    @JoinColumn(name = "VillageIdf")
    Village village ;

    @ManyToOne
    @JoinColumn(name = "FarmIdf")
    Farm farm;

    @ManyToOne
    @JoinColumn(name = "CropIdf")
    Crop crop ;
}
