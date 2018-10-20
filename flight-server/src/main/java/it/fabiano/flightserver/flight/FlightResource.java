package it.fabiano.flightserver.flight;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Gaetano Fabiano
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class FlightResource {

	@Autowired
	private FlightRepository flightRepository;

	@GetMapping("/flights")
	public List<Flight> retrieveAllFlights() {
		return flightRepository.findAll();
	}

	@GetMapping("/flights/{id}")
	public Flight retrieveFlight(@PathVariable long id) {
		Optional<Flight> flight = flightRepository.findById(id);

		if (!flight.isPresent())
			throw new FlightNotFoundException("id-" + id);

		return flight.get();
	}

	@DeleteMapping("/flights/{id}")
	public void deleteFlight(@PathVariable long id) {
		flightRepository.deleteById(id);
	}

	@PostMapping("/flights")
	public ResponseEntity<Object> createFlight(@RequestBody Flight flight) {
		Flight flightToSave = flightRepository.save(flight);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(flightToSave.getFlightNumber()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/flights/{id}")
	public ResponseEntity<Object> updateFlight(@RequestBody Flight flight, @PathVariable long id) {

		Optional<Flight> flightOptional = flightRepository.findById(id);

		if (!flightOptional.isPresent())
			return ResponseEntity.notFound().build();

		flight.setFlightNumber(id);
		
		flightRepository.save(flight);

		return ResponseEntity.noContent().build();
	}
}
