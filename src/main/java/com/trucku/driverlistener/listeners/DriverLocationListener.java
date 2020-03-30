package com.trucku.driverlistener.listeners;

import java.math.BigInteger;
import java.util.List;

import com.trucku.driverlistener.models.entities.City;
import com.trucku.driverlistener.models.rest.DriverLocation;
import com.trucku.driverlistener.services.CityService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Component
public class DriverLocationListener {
    
    private static Logger log = LogManager.getLogger(DriverLocationListener.class);

    private CityService citySvc;

    @KafkaListener(id = "driver-listener", topics = "driver-locations")
    public void listen(DriverLocation location) {
        log.info(location);

        List<City> nearbyCities = citySvc.findCitiesInRadiusNear(location, BigInteger.valueOf(50L));
        log.info(nearbyCities);
    }
}