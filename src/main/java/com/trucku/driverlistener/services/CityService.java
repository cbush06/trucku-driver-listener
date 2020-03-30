package com.trucku.driverlistener.services;

import java.math.BigInteger;
import java.util.List;

import com.trucku.driverlistener.models.entities.City;
import com.trucku.driverlistener.models.rest.Location;

public interface CityService {

    List<City> findCitiesInRadiusNear(Location location, BigInteger radiusKm);
    
}