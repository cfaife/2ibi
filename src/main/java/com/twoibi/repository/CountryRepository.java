package com.twoibi.repository;

import com.twoibi.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Long> {

    String FETCH_ALL = "SELECT c FROM CountryEntity  c ";

    String FETCH_BY_NAME = "SELECT c " +
                            "FROM CountryEntity  c " +
                            " WHERE c.name = :name";


    @Query(FETCH_ALL)
    List<CountryEntity> fetchAll();

    @Query(FETCH_BY_NAME)
    Optional<CountryEntity> fetchByName(String name);
}
