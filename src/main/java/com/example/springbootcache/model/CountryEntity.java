package com.example.springbootcache.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String capital;
    private Long population;
}
