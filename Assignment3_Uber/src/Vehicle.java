
public abstract class Vehicle implements Comparable {
	
	int licenseNumber;
	String model;
	int year;
	Driver driver;

	//constructor
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
	
	//func to add a driver to the vehicle
	public boolean addDriver(Driver driver) {
		
		if (this.driver != null) {
			return false;
		} else {
			this.driver = driver;
			return true;
		}
		
	}
	
	//calculate driving time based on a given distance
	public abstract double calculateDrivingTime(double distance);
	
	public int compareTo(Object other) {
		return this.year - ((Vehicle)other).year;
	}
	
}
