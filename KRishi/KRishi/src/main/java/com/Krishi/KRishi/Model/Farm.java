package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbfarm")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FarmIDP")
    Long id ;



    @Column(name = "FarmSize")
    String size ;

    @ManyToOne
    @JoinColumn(name = "SoilIDF")
    Soil soil;
    @ManyToOne
     @JoinColumn(name = "IrrigationTypeIDF")
    IrrigationType irrigation ;

}
