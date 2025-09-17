package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbcropactivity")
public class CropActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cropactivityidp")
    private int id;

    @Column(name = "activity")
    private  String activity;
}
