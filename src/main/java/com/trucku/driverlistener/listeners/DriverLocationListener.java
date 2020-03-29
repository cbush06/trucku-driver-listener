package com.trucku.driverlistener.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DriverLocationListener {
    
    private static Logger log = LogManager.getLogger(DriverLocationListener.class);

    @KafkaListener(id = "driver-listener", topics = "driver-locations")
    public void listen(String data) {
        log.info(data);
    }
}