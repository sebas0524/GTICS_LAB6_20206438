package com.example.lab06_20206438.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name="site")
public class Sitio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID",nullable = false)
    private  Integer siteId;
    @Column(name="SiteName")
    private String sitionombre;
    @Column(name="InstallationDate")
    private Date dia;
    @Column(name="Latitud")
    private String latitud;
    @Column(name="Longitude")
    private String longitud;
    @ManyToOne
    @JoinColumn(name="LocationID")
    private Location locationId;
}
