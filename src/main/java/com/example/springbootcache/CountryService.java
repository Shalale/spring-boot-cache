package com.example.springbootcache;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "countrie")
public class CountryService {
    private final CountryRepository repository;

    @Cacheable
    public List<CountryEntity> getCountries() {
        return repository.findAll();
    }

    public void addCountry(CountryEntity country) {
        repository.save(country);
    }

    @CachePut
    public void updateCountry(Long id, CountryEntity country) {
        CountryEntity last = repository.getReferenceById(id);
        last.setPopulation(country.getPopulation());
        repository.save(country);
    }

    @CacheEvict
    public void cacheEvict(){

    }


}
