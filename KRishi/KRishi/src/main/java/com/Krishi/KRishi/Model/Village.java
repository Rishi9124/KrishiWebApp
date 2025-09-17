package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbvillage")
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "villageidp")
    Long id;

    @Column(name = "villagename")
    String name;

    @ManyToOne
    @JoinColumn(name = "talukaidf")
    Taluka taluka;


}
