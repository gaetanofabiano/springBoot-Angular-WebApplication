package it.fabiano.flightserver.scheduler;

/**
 * @author Gaetano Fabiano
 *
 */
public class FlightSchedulerInput {
	private int numberOfFligths;
	private double probabilityOfCancelled;
	private double probabilityOfDelayed;
	private String name;
	public FlightSchedulerInput() {
		super();
	}
	public FlightSchedulerInput(int numberOfFligths, double probabilityOfCancelled, double probabilityOfDelayed,
			String name) {
		super();
		this.numberOfFligths = numberOfFligths;
		this.probabilityOfCancelled = probabilityOfCancelled;
		this.probabilityOfDelayed = probabilityOfDelayed;
		this.name = name;
	}
	public int getNumberOfFligths() {
		return numberOfFligths;
	}
	public double getProbabilityOfCancelled() {
		return probabilityOfCancelled;
	}
	public double getProbabilityOfDelayed() {
		return probabilityOfDelayed;
	}
	public String getName() {
		return name;
	}
	public void setNumberOfFligths(int numberOfFligths) {
		this.numberOfFligths = numberOfFligths;
	}
	public void setProbabilityOfCancelled(double probabilityOfCancelled) {
		this.probabilityOfCancelled = probabilityOfCancelled;
	}
	public void setProbabilityOfDelayed(double probabilityOfDelayed) {
		this.probabilityOfDelayed = probabilityOfDelayed;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
