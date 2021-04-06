package com.twoibi.service;

import com.twoibi.entity.CountryEntity;
import com.twoibi.exception.DuplicatedCountryNameException;
import com.twoibi.repository.CountryRepository;
import com.twoibi.utils.OrderKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<CountryEntity> readAll(OrderKey orderKey) {

         if(orderKey == OrderKey.BY_NAME){
            return this.countryRepository.fetchAll()
                    .stream().sorted((a,b)->a.getName().compareTo(b.getName()))
                    .collect(Collectors.toList());
        }
        else if(orderKey == OrderKey.BY_REGION){
            return this.countryRepository.fetchAll()
                    .stream().sorted((a,b)->a.getRegion().compareTo(b.getRegion()))
                    .collect(Collectors.toList());
        }
        else if(orderKey == OrderKey.BY_SUBREGION){
            return this.countryRepository.fetchAll()
                    .stream().sorted((a,b)->a.getSubRegion().compareTo(b.getSubRegion()))
                    .collect(Collectors.toList());
        }
        else if(orderKey == OrderKey.BY_AREA){
            return this.countryRepository.fetchAll()
                    .stream().sorted((a,b)->a.getArea().compareTo(b.getArea()))
                    .collect(Collectors.toList());
        }
        else if(orderKey == OrderKey.BY_CAPITAL){
            return this.countryRepository.fetchAll()
                    .stream().sorted((a,b)->a.getCapital().compareTo(b.getCapital()))
                    .collect(Collectors.toList());
        }else {
            return this.countryRepository.fetchAll();
        }

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
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("the values cant be 0 nor NULL");
        }
        Optional<CountryEntity> retrievedCountry = this.countryRepository.findById(id);

        if(retrievedCountry.isPresent()){
            this.countryRepository.delete(this.countryRepository.findById(id).get());
            return  ResponseEntity.status(HttpStatus.OK).body("Country: "+retrievedCountry.get().getName()+" removed from the system");
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No country found with this id:"+id);
        }
    }

    private Optional<CountryEntity> checkCoubtriesDupliactions(String name){

       Optional<CountryEntity> retrievedEntity = this.countryRepository.fetchByName(name);

       retrievedEntity.ifPresent(x -> { throw  new DuplicatedCountryNameException(name);});

       return Optional.empty();

    }
}
