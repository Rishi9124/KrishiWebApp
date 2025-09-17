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
@Table(name = "tbtaluka")
public class Taluka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "talukaidp")
     private Long id ;

    @Column(name = "talukaname")
    private String name ;

    @ManyToOne
    @JoinColumn(name = "districtidf")
     District district ;
}
