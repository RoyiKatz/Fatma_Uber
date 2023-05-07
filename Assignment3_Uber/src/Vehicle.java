import Exceptions.InvalidYearException;
import Interfaces.Comparable;

public abstract class Vehicle implements Comparable<Vehicle> {
	
	protected int licenseNumber;
	protected String model;
	protected int year;
	protected Driver driver;
	protected boolean is_deliverable;

	// constructor
	public Vehicle(int licenseNumber, String model, int year) {
		
		driver = null;
		this.licenseNumber = licenseNumber;
		this.model = model;
		
		//check year validity
		if (year >= 1970 && year <= 2022) {
			this.year = year;
		} else {
			throw new InvalidYearException("invalid year of production - " + year + ". Year must be between 1970-2022");
		}
		
	}
	
	
	// getters
	public int year() {
		return year;
	}
	
	public boolean isDeliverable() {
		return is_deliverable;
	}
	
	
	// func to add a driver to the vehicle
	public boolean addDriver(Driver driver) {
		
		if (this.driver != null) {
			return false;
		} else {
			this.driver = driver;
			return true;
		}
		
	}
	
	
	// calculate driving time based on a given distance
	public abstract double calculateDrivingTime(double distance);
	
	
	public int compareTo(Vehicle other) {
		return this.year - other.year();
	}
	
}
