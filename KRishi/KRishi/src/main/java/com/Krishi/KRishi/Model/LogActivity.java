package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tblogactivity")
public class LogActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logactivityidp")
    private int  id ;

    String date;

    @ManyToOne
    @JoinColumn(name = "cropidf")
    Crop crop;

    @ManyToOne
    @JoinColumn(name = "cropactivityidf")
    CropActivity cropActivity;

    @ManyToOne
    @JoinColumn(name = "profileidf")
    Profile profile ;
}
