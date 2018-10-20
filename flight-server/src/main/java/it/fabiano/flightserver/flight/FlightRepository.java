package it.fabiano.flightserver.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gaetano Fabiano
 *
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

}
