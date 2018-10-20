package it.fabiano.flightserver.scheduler;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import it.fabiano.flightserver.company.CompanyRepository;
import it.fabiano.flightserver.flight.FlightRepository;

/**
 * @author Gaetano Fabiano
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class FlightSchedulerResource {


		@Autowired
		private FlightRepository flightRepository;
		@Autowired
		private CompanyRepository companyRepository;

		/**
		 * Not for use, for test only, Should not use Get to storage data
		 */
		@GetMapping("/generateSampleSimulator")
		public void generateSampleSimulator(){
			int numberOfFligths = 10;
			double probabilityOfCancelled = 30;
			double probabilityOfDelayed=20;
			String name = "RYANAIR";
			

			FlightSchedulerFactory.generateAndSaveFlight(numberOfFligths, probabilityOfCancelled, probabilityOfDelayed, name,this.flightRepository,this.companyRepository);
		}
		/**
		 * Not for use, for test only, Should not use Get to storage data
		 */
		@GetMapping("/simulator/{numberOfFligths}/{probabilityOfCancelled}/{probabilityOfDelayed}/{name}")
		public void generateSampleSimulator(@PathVariable int numberOfFligths,double probabilityOfCancelled,double probabilityOfDelayed,String name) {
	
			FlightSchedulerFactory.generateAndSaveFlight(numberOfFligths, probabilityOfCancelled, probabilityOfDelayed, name,this.flightRepository,this.companyRepository);
		}
		
		/**
		 * @param FlightSchedulerInput
		 * @return
		 */
		@PostMapping("/simulator")
		public ResponseEntity<Object> generateSampleSimulator(@RequestBody FlightSchedulerInput input) {
			FlightSchedulerFactory.generateAndSaveFlight(input.getNumberOfFligths(), input.getProbabilityOfCancelled(), input.getProbabilityOfDelayed(), input.getName(),this.flightRepository,this.companyRepository);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(input.getName()).toUri();
			return ResponseEntity.created(location).build();

		}
		
		
	

}
