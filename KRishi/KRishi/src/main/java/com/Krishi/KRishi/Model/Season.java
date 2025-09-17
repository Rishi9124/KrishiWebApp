package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbseoson")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seasonidp")
    private int  id ;

    @Column(name = "seasonname")
    private String name ;
}
