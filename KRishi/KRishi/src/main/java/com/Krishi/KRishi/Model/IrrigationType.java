package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbiriigationType")
public class IrrigationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IriigationIDP")
    private Long id ;

    @Column(name = "IrrigationType")
    String irrigationType;
}
