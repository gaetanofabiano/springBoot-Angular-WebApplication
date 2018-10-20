package it.fabiano.flightserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Gaetano Fabiano
 *
 */
@SpringBootApplication
public class FlightServerApplication {

	public static void main(String[] args) {
		 //System.setProperty("server.servlet.context-path", "/user-portal");
		SpringApplication.run(FlightServerApplication.class, args);
	}
}
