package com.example.demo.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROVINCES")
public class Province {
    @Id
    @Column(name = "PROVINCE_ID",columnDefinition = "varchar(5)")
    private String id;

    @Column(name = "_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
    List<Address> addresses;
}