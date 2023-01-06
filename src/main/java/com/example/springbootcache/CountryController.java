package com.example.springbootcache;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/countries")
public class CountryController {
    private final CountryService service;

    @GetMapping("/all")
    public List<CountryEntity> getCountries(){
        return service.getCountries();
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
