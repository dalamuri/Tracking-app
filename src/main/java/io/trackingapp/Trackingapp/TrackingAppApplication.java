package io.trackingapp.Trackingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrackingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackingAppApplication.class, args);
	}

}
