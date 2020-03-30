package com.trucku.driverlistener.repos;

import java.math.BigInteger;

import com.trucku.driverlistener.models.entities.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, BigInteger> {
    
    

}