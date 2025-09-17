package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbcropmanagement")
public class CropManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cropmanagementidp")
    Long id ;

    @ManyToOne
    @JoinColumn(name = "cropidf")
    Crop crop;

    @ManyToOne
    @JoinColumn(name = "farmidf")
    Farm farm;

    @ManyToOne
    @JoinColumn(name = "seasonidf")
    Season season ;

    @ManyToOne
    @JoinColumn(name = "Profileidf")
    Profile profile ;
}
