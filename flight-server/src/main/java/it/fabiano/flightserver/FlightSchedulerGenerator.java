package it.fabiano.flightserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import it.fabiano.flightserver.company.CompanyRepository;
import it.fabiano.flightserver.flight.FlightRepository;
import it.fabiano.flightserver.scheduler.FlightSchedulerFactory;

/**
 * @author Gaetano Fabiano
 *
 */
@Component
@SpringBootApplication
public class FlightSchedulerGenerator implements ApplicationRunner{

	private FlightRepository flightRepository;
	private CompanyRepository companyRepository;

	@Autowired
	public void DataLoader(FlightRepository flightRepository,CompanyRepository companyRepository) {
		this.flightRepository = flightRepository;
		this.companyRepository =companyRepository;
	}
	@Override
	public void run(ApplicationArguments args) {

		int numberOfFligths = 10;
		double probabilityOfCancelled = 30;
		double probabilityOfDelayed=20;
		String name = "ALITALIA";
		

		FlightSchedulerFactory.generateAndSaveFlight(numberOfFligths, probabilityOfCancelled, probabilityOfDelayed, name,this.flightRepository,this.companyRepository);


	}
}
