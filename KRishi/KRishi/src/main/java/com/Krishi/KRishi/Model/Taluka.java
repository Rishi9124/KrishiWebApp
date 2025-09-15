package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbTaluka")
public class Taluka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TalukaIDP")
     private Long id ;

    @Column(name = "TalukaName")
    private String name ;

    @ManyToOne
    @JoinColumn(name = "DistrictIDF")
     District district ;
}
