package com.trucku.driverlistener.listeners;

import com.trucku.driverlistener.models.rest.DriverLocation;
import com.trucku.driverlistener.services.CityService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Component
public class DriverLocationListener {
    
    private static Logger log = LogManager.getLogger(DriverLocationListener.class);

    private RedisOperations<String, String> redisOps;

    @KafkaListener(id = "driver-listener", topics = "driver-locations")
    public void listen(DriverLocation location) {
        GeoOperations<String, String> geoOps = redisOps.opsForGeo();
        Long itemsAdded = geoOps.add("driver-locations", new Point(location.getLongitude().doubleValue(), location.getLatitude().doubleValue()), location.getDriver());
        log.info("Added {} items to [{}]", itemsAdded, "driver-locations");
    }
}