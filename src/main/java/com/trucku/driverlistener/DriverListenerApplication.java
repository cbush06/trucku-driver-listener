package com.trucku.driverlistener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriverListenerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DriverListenerApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Press CTRL+C to exit...");
        Thread.currentThread().join();
    }

}
