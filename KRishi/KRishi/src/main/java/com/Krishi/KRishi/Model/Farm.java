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
    @Column(name = "farmidp")
    Long id ;



    @Column(name = "farmsize")
    String size ;

    @ManyToOne
    @JoinColumn(name = "soilidf")
    Soil soil;
    @ManyToOne
     @JoinColumn(name = "irrigationtypeidf")
    IrrigationType irrigation ;

    @ManyToOne
    @JoinColumn(name = "profileidf")
    Profile profile;

}
