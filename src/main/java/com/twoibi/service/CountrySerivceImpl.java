package com.twoibi.service;

import com.twoibi.entity.CountryEntity;
import com.twoibi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Clerio Alfredo Faife
 */
@Service
public class CountrySerivceImpl  implements  CountryService{

    private CountryRepository countryRepository;

    @Autowired
    public CountrySerivceImpl(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<CountryEntity> createCountry(CountryEntity countryEntity) {

        this.checkCoubtriesDupliactions(countryEntity.getName());

        CountryEntity savedCountry =
                this.countryRepository.saveAndFlush(countryEntity);

        return Optional.of(savedCountry);
    }

    @Override
    public Optional<CountryEntity> updateCountry(CountryEntity countryEntity) {

        CountryEntity updatedCountry =
                this.countryRepository.save(countryEntity);

        return Optional.of(updatedCountry);

    }

    @Override
    public List<CountryEntity> readAll() {
        return this.countryRepository.fetchAll();
    }

    @Override
    public Optional<CountryEntity> readByName(String name) {
        return this.countryRepository.fetchByName(name);
    }

    @Override
    public Optional<CountryEntity> readById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public ResponseEntity deleteCoutry(Long id) {
        if(id == 0 || id ==null){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Optional<CountryEntity> retreivedCountry = this.countryRepository.findById(id);

        if(retreivedCountry.isPresent()){
            this.countryRepository.delete(this.countryRepository.findById(id).get());
            return  ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private Optional<CountryEntity> checkCoubtriesDupliactions(String name){

       Optional<CountryEntity> retrievedEntity = this.countryRepository.fetchByName(name);

       retrievedEntity.ifPresent(x -> { throw  new RuntimeException("There is a country created with this name:"+name);});

       return Optional.empty();

    }
}
