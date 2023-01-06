package com.example.springbootcache;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "country")
public class CountryEntity {
    @Id
    private Long id;
    private String name;
    private String capital;
    private Long population;
}
