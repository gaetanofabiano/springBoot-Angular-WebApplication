package it.fabiano.flightserver.scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import it.fabiano.flightserver.company.Company;
import it.fabiano.flightserver.company.CompanyRepository;
import it.fabiano.flightserver.flight.Flight;
import it.fabiano.flightserver.flight.FlightRepository;

/**
 * @author Gaetano Fabiano
 *
 */
public class FlightSchedulerFactory {

	public static void generateAndSaveFlight(int numberOfFligths, double probabilityOfCancelled, double probabilityOfDelayed,
			String companyName,FlightRepository flightRepository,CompanyRepository companyRepository) {
		Random r = new Random();

		int numberOfCancelled = (int) Math.round((probabilityOfCancelled*numberOfFligths)/100);
		int numberOfDelayed = (int) Math.round((probabilityOfDelayed*numberOfFligths)/100);

		System.out.println("numberOfCancelled "+numberOfCancelled);
		System.out.println("numberOfDelayed "+numberOfDelayed);
		ArrayList<Flight> flights = new ArrayList<Flight>();

		Company alitalia = new Company(companyName);

		//Delayed
		for(int j=0;j<numberOfDelayed;j++) {

			LocalDateTime scheduledTime = LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), r.nextInt(24), r.nextInt(60));
			LocalDateTime estimatedTime = scheduledTime.plusHours(r.nextInt(3)+1);
			Flight flight = new Flight(alitalia.getName(),getSourceAirport(),getDestinationAirport(),"delayed",scheduledTime,estimatedTime,estimatedTime.plusMinutes(15+r.nextInt(60)),true);
			flights.add(flight);		
		}
		//Cancelled
		for(int i=0;i<numberOfCancelled;i++){
			LocalDateTime scheduledTime = LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), r.nextInt(24), r.nextInt(60));
			LocalDateTime estimatedTime = scheduledTime.plusHours(r.nextInt(3)+1);
			Flight flight = new Flight(alitalia.getName(),getSourceAirport(),getDestinationAirport(),"cancelled",scheduledTime,estimatedTime,null,false);
			flights.add(flight);		

		}

		//Others
		int others = numberOfFligths-(numberOfDelayed+numberOfCancelled);
		System.out.println("others "+others);
		for(int k=0;k<others;k++) {
			String status = getStatus();
			if(status.equals("scheduled")){
				LocalDateTime scheduledTime = LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), r.nextInt(24), r.nextInt(60));
				LocalDateTime estimatedTime = scheduledTime.plusHours(r.nextInt(3)+1);
				Flight flight = new Flight(alitalia.getName(),getSourceAirport(),getDestinationAirport(),"scheduled",scheduledTime,estimatedTime,estimatedTime,false);
				flights.add(flight);	
			}
			else if(status.equals("operating")){
				LocalDateTime scheduledTime = LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), r.nextInt(24), r.nextInt(60));
				LocalDateTime estimatedTime = scheduledTime.plusHours(r.nextInt(3)+1);
				Flight flight = new Flight(alitalia.getName(),getSourceAirport(),getDestinationAirport(),"operating",scheduledTime,estimatedTime,estimatedTime.plusMinutes(r.nextInt(30)),false);
				flights.add(flight);	
			}
		}

		flights.forEach((f)->flightRepository.save(f));	
		alitalia.setFlights(flights);

		companyRepository.save(alitalia);
	}

	private static String getStatus(){
		String[] value = 
			{"scheduled","operating"};
		Random r = new Random();
		return value[r.nextInt(value.length)];
	}
	private static String getSourceAirport(){
		String[] value = 
			{"Albenga Aeroporto di Albenga Villanova - Clemente Panero ALL","Alghero Aeroporto di Alghero - Fertilia AHO","Ancona Aeroporto di Ancona Falconara - Raffaello Sanzio AOI","Aosta Aeroporto di Aosta - Corrado Gex AOT","Bari Aeroporto di Bari - Palese BRI","Bergamo Aeroporto di Bergamo - Orio al Serio International BGY","Bologna Aeroporto di Bologna Borgo Panigale - G. Marconi BLQ","Bolzano Aeroporto di Bolzano - ABD Airport Bolzano Dolomiti BZO","Brescia Aeroporto di Brescia Montichiari - Gabriele D'Annunzio VBS","Brindisi Aeroporto di Brindisi Papola Casale - O. Perazzi BDS","Cagliari Aeroporto di Cagliari Elmas - Mario Mameli CAG","Catania Aeroporto di Catania Fontanarossa - Filippo Eredia CTA","Crotone Aeroporto di Crotone - S. Anna CRV","Cuneo Aeroporto di Cuneo - Levaldigi CUF","Firenze Aeroporto di Firenze - Amerigo Vespucci FLR","Foggia Aeroporto di Foggia - G. Lisa FOG","Genova Aeroporto di Genova - Cristoforo Colombo GOA","Lamezia terme Aeroporto di Lamezia Terme - S. Eufemia SUF","Lampedusa Aeroporto di Lampedusa - Lampedusa LMP","Milano Aeroporto di Milano - Linate LIN","Milano Aeroporto di Milano - Malpensa MXP","Napoli Aeroporto di Napoli Capodichino - Ugo Niutta International NAP","Olbia Aeroporto di Olbia - Costa Smeralda OLB","Padova Aeroporto di Padova - Gino Allegri OPA","Palermo Aeroporto di Palermo Punta Raisi - Falcone e Borsellino PMO","Pantelleria Aeroporto di Pantelleria - Pantelleria PNL","Parma Aeroporto di Parma - Giuseppe Verdi PMF","Perugia Aeroporto di Perugia San Egidio - Adamo Giuglietti PEG","Pescara Aeroporto di Pescara D'Abruzzo - Pasquale Liberi PSR","Pisa Aeroporto di Pisa - Galileo Galilei PSA"};
		Random r = new Random();
		return value[r.nextInt(value.length)];
	}

	private static String getDestinationAirport(){
		String[] value =
			{"Reggio calabria Aeroporto di Reggio Calabria - Tito Minniti REG","Rimini Aeroporto di Rimini - Federico Fellini RMI","Roma Aeroporto di Roma Ciampino - G.B. Pastine CIA",					"Roma Aeroporto di Roma Fiumicino - Leonardo da Vinci FCO",					"Salerno Aeroporto di Salerno - Costa d'Amalfi QSR",					"Siena Aeroporto di Siena - Ampugnano Aeroporto SAY",					"Taranto Aeroporto di Taranto Grottaglie - Marcello Arlotta TAR","Torino Aeroporto di Torino - Caselle - Sandro Pertini TRN","Treviso Aeroporto di Treviso - Antonio Canova TSF",					"Trieste Aeroporto di Trieste - Ronchi dei Legionari TRS","Venezia Aeroporto di Venezia Tessera - Marco Polo VCE","Verona Aeroporto di Verona Villafranca - Valerio Catullo VRN","Vicenza Aeroporto di Vicenza - Tommaso Dal Molin VIC"};
		Random r = new Random();
		return value[r.nextInt(value.length)];
	}

}
