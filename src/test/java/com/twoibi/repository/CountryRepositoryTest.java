package com.twoibi.repository;

import com.twoibi.entity.CountryEntity;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Clerio Alfredo Faife
 */


public class CountryRepositoryTest {

    @Test
    public  void findAll_shouldPass(){

        CountryRepository countryRepository = Mockito.mock(CountryRepository.class);

        CountryEntity mozambique = new CountryEntity(null,
                "Mozambique","Maputo","South of Africa", "Africa Austral",801590d);
        CountryEntity brazil = new CountryEntity(null,
                "Brazil","Brazilia","South of America", "South of America",8525989d);
        List<CountryEntity> countries = Arrays.asList(mozambique,brazil);

        Mockito.when(countryRepository.fetchAll()).thenReturn(countries);


    }

    @Test
    public  void findByName_shouldPass(){

        CountryRepository countryRepository = Mockito.mock(CountryRepository.class);

        CountryEntity mozambique = new CountryEntity(null,
                "Mozambique","Maputo","South of Africa", "Africa Austral",801590d);
        CountryEntity brazil = new CountryEntity(null,
                "Brazil","Brazilia","South of America", "South of America",8525989d);
        List<CountryEntity> countries = Arrays.asList(mozambique,brazil);

        Mockito.when(countryRepository.fetchByName("Mozambique")).thenReturn(Optional.of(countries.get(0)));


    }


}
