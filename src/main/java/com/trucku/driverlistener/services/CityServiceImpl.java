package com.trucku.driverlistener.services;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.trucku.driverlistener.models.entities.City;
import com.trucku.driverlistener.models.rest.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Service
public class CityServiceImpl implements CityService {

    private static final BigInteger BIGINT_1000 = BigInteger.valueOf(1000L);

    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<City> findCitiesInRadiusNear(Location location, BigInteger radiusKm) {
        Query q = em.createNativeQuery(
            "SELECT * " + 
            // "   geonameId, " +
            // "   name, " +
            // "   asciiname, " +
            // "   alternatenames, " +
            // "   lat, " +
            // "   lon, " +
            // "   population, " +
            // "   elevation, " +
            // "   digital_elevation_model, " +
            // "   feature_class, " +
            // "   feature_code, " +
            // "   country_code, " +
            // "   country_code_alt, " +
            // "   admin1_code, " +
            // "   admin2_code, " +
            // "   admin3_code, " +
            // "   admin4_code, " +
            // "   timezone, " +
            // "   modification_date " +
            "FROM all_cities " +
            "WHERE ST_DWithin(latlon, CAST('POINT(' || ?1 || ' ' || ?2 || ')' AS geometry), ?3, false)", City.class);
        q.setParameter(1, location.getLongitude());
        q.setParameter(2, location.getLatitude());
        q.setParameter(3, radiusKm.multiply(BIGINT_1000));
        return (List<City>) q.getResultList();
    }
}