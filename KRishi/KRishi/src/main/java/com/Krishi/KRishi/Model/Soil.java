package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbsoil")
public class Soil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soilidp")
    Long id ;

    @Column(name = "type")
    String type ;
}
