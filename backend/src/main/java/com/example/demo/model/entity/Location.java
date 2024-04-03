package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOCATIONS")
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    private String id;

    @Column(name = "_NAME")
    private String name;

    @Column(name = "PROVINCE_FK")
    private Integer provinceFk;



}