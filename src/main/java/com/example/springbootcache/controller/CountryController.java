package com.example.springbootcache.controller;

import com.example.springbootcache.model.CountryEntity;
import com.example.springbootcache.servise.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/countries")
public class CountryController {
    private final CountryService service;

    @GetMapping("/{id}")
    public CountryEntity getCountry(@PathVariable Long id){
        return service.getCountry(id);
    }

    @PostMapping
    public void addCountry(@RequestBody CountryEntity country){
        service.addCountry(country);
    }

    @PutMapping("/{id}")
    public void updateCountry(@PathVariable Long id, @RequestBody CountryEntity country){
        service.updateCountry(id, country);
    }

    @GetMapping("/evict")
    public void cacheEvict(){
        service.cacheEvict();
    }
}
