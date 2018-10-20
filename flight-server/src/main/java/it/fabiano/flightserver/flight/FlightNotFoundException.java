package it.fabiano.flightserver.flight;

/**
 * @author Gaetano Fabiano
 *
 */
public class FlightNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3714856767075124328L;

	public FlightNotFoundException(String exception) {
		super(exception);
	}

}
