package com.twoibi.service;

import com.twoibi.entity.CountryEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Clerio Alfredo Faife
 */
public interface CountryService {
    Optional<CountryEntity> createCountry(CountryEntity countryEntity);

    Optional<CountryEntity> updateCountry(CountryEntity countryEntity);

    List<CountryEntity> readAll();

    Optional<CountryEntity> readByName(String name);

    Optional<CountryEntity> readById(Long id);

    ResponseEntity deleteCoutry(Long id);
}
