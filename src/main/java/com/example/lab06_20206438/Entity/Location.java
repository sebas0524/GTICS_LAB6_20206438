package com.example.lab06_20206438.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocaitonID", nullable = false)
    private Integer siteId;
    @Column(name = "City")
    private String ciudad;
    @Column(name = "Country")
    private String pais;
}
