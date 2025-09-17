package com.Krishi.KRishi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "useridp")
    Long id ;

    @Column(name = "phonenumber")
    String phoneNumber;

    @Column(name = "isvarified")
    boolean isvarified ;

    @ManyToOne
    @JoinColumn(name = "Villageidf")
    Village village ;

    @ManyToOne
    @JoinColumn(name = "farmidf")
    Farm farm;

    @ManyToOne
    @JoinColumn(name = "cropidf")
    Crop crop ;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "cropsnowingdate" , nullable = true)
    Date date;
}
