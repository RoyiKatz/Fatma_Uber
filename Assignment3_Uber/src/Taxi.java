import Exceptions.InvalidPassengerException;

public class Taxi extends Vehicle {

	protected int maxPassengers;

	// constructor
	public Taxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers) {
		super(licenseNumber, model, year);

		base_fare = baseFare;

		if (validPassengers(maxPassengers)) {
			this.maxPassengers = maxPassengers;
		} else {
			throw new InvalidPassengerException("invalid number of passangers!");
		}
		
		is_deliverable = true;
	}

	// validate max passengers number
	protected boolean validPassengers(int maxPassengers) {
		return maxPassengers >= 1 && maxPassengers <= 4;
	}
	
	
	//getter
	protected String getType() {

		return "Taxi";
	}	
	

	// calculate driving time based on a given distance
	public double calculateDrivingTime(double distance) {
		
		double P = 0.5 + (Math.random() * 0.2);
		
		return (distance / (100 * P)) + 2;
		
	}

}
