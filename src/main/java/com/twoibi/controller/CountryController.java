package com.twoibi.controller;

import com.twoibi.entity.CountryEntity;
import com.twoibi.service.CountryService;
import com.twoibi.utils.OrderKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Clerio Alfredo Faife
 */
@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryEntity>> fetchAll(){

        return ResponseEntity.of(Optional.of(this.countryService.readAll(null)));
    }

    @GetMapping("/order/{orderKey}")
    public ResponseEntity<List<CountryEntity>> fetchAll(
            @PathVariable("orderKey") String orderKey ){

        OrderKey key = OrderKey.parse(orderKey);
        return ResponseEntity.of(Optional.of(this.countryService.readAll(key)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryEntity> fetchById(@PathVariable("id") Long id){

        return ResponseEntity.of(this.countryService.readById(id));
    }

    @PostMapping
    public ResponseEntity create(
            @RequestBody CountryEntity countryEntity){

       CountryEntity createdCountry =
               this.countryService.createCountry(countryEntity).get();

       Link resouceLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(CountryController.class)
                        .fetchById(createdCountry.getId())).withRel("country");

        countryEntity.add(resouceLink);

       return  ResponseEntity
               .status(HttpStatus.CREATED)
               .body(createdCountry);
    }

    @PutMapping
    public ResponseEntity<CountryEntity>  update(
            @RequestBody CountryEntity countryEntity){

        CountryEntity updatedCountry =
                this.countryService.updateCountry(countryEntity).get();
        return  ResponseEntity.of(Optional.of(updatedCountry));
    }

    @DeleteMapping("/{countryId}")
    public ResponseEntity  delete(
            @PathVariable("countryId") Long countryId){

        return this.countryService.deleteCoutry(countryId);

    }
}
