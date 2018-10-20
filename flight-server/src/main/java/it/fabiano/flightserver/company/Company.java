package it.fabiano.flightserver.company;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import it.fabiano.flightserver.flight.Flight;

/**
 * @author Gaetano Fabiano
 *
 */
@Entity
public class Company {
    
	@Id
    @GeneratedValue
    private Long id;

    private String name;

    
    @OneToMany
    private List<Flight> flights = new ArrayList<Flight>();

    public Company() {
		super();
	}
	public Company( @NotNull String name) {
		super();
	
		this.name = name;
	
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the flights
	 */
	public List<Flight> getFlights() {
		return flights;
	}
	/**
	 * @param flights the flights to set
	 */
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	

    

}