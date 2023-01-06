package com.example.springbootcache.servise;

import com.example.springbootcache.model.CountryEntity;
import com.example.springbootcache.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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

    @SneakyThrows
    @Cacheable(cacheNames = "country")
    public CountryEntity getCountry(Long id) {
        Thread.sleep(3000);
        return repository.findById(id).orElseThrow();
    }

    public void addCountry(CountryEntity country) {
        repository.save(country);
    }

    @CachePut(cacheNames = "country", key = "#id")
    public void updateCountry(Long id, CountryEntity country) {
        CountryEntity last = repository.getReferenceById(id);
        last.setPopulation(country.getPopulation());
        repository.save(country);
    }

    @CacheEvict(cacheNames = "country", allEntries = true)
    public void cacheEvict(){
    }


}
