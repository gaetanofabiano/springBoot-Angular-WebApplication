package it.fabiano.flightserver.flight;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * 
flight number and should include at least information regarding:
Company
Source airport
Destination Airport
Flight status {scheduled, operating, cancelled}
Scheduled time: is the time planned for arrival/departure
Estimated time: is the time estimated for the flight arrival/departure it change in case of delay 
Actual time: the effective arrival/departure time assigned when the flight arrives/depart
 */
/**
 * @author Gaetano Fabiano
 *
 */
@Entity
public class Flight {
	@Id
	@GeneratedValue
	private long flightNumber;
	private String companyNameDescription;
	private String sourceAirport;
	private String destinationAirport;
	private String flightStatus;
	private LocalDateTime scheduledTime;
	private LocalDateTime estimatedTime; 
	private LocalDateTime actualTime;
	private boolean delayed=false;
	public Flight() {
		super();
	}
	
	
	
	public Flight( String companyNameDescription,String sourceAirport, String destinationAirport,
			String flightStatus, LocalDateTime scheduledTime, LocalDateTime estimatedTime, LocalDateTime actualTime,boolean delayed) {
		super();
		this.companyNameDescription=companyNameDescription;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.flightStatus = flightStatus;
		this.scheduledTime = scheduledTime;
		this.estimatedTime = estimatedTime;
		this.actualTime = actualTime;
		this.delayed=delayed;
	}



	/**
	 * @return the flightNumber
	 */
	public long getFlightNumber() {
		return flightNumber;
	}

	/**
	 * @return the sourceAirport
	 */
	public String getSourceAirport() {
		return sourceAirport;
	}
	/**
	 * @return the destinationAirport
	 */
	public String getDestinationAirport() {
		return destinationAirport;
	}
	/**
	 * @return the flightStatus
	 */
	public String getFlightStatus() {
		return flightStatus;
	}
	/**
	 * @return the scheduledTime
	 */
	public LocalDateTime getScheduledTime() {
		return scheduledTime;
	}
	/**
	 * @return the estimatedTime
	 */
	public LocalDateTime getEstimatedTime() {
		return estimatedTime;
	}
	/**
	 * @return the actualTime
	 */
	public LocalDateTime getActualTime() {
		return actualTime;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * @param sourceAirport the sourceAirport to set
	 */
	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	/**
	 * @param destinationAirport the destinationAirport to set
	 */
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	/**
	 * @param flightStatus the flightStatus to set
	 */
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	/**
	 * @param scheduledTime the scheduledTime to set
	 */
	public void setScheduledTime(LocalDateTime scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	/**
	 * @param estimatedTime the estimatedTime to set
	 */
	public void setEstimatedTime(LocalDateTime estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	/**
	 * @param actualTime the actualTime to set
	 */
	public void setActualTime(LocalDateTime actualTime) {
		this.actualTime = actualTime;
	}



	/**
	 * @return the companyNameDescription
	 */
	public String getCompanyNameDescription() {
		return companyNameDescription;
	}



	/**
	 * @param companyNameDescription the companyNameDescription to set
	 */
	public void setCompanyNameDescription(String companyNameDescription) {
		this.companyNameDescription = companyNameDescription;
	}



	/**
	 * @return the delayed
	 */
	public boolean isDelayed() {
		return delayed;
	}



	/**
	 * @param delayed the delayed to set
	 */
	public void setDelayed(boolean delayed) {
		this.delayed = delayed;
	}


		
}
