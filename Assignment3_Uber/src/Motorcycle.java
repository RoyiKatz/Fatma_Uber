
public class Motorcycle extends Vehicle {
	
	private int maxSpeed;
	private double engineDisplacement;
	
	//constructor
	public Motorcycle(int licenseNumber, String model, int year, int maxSpeed, double engineDisplacement) {
		
		super(licenseNumber, model, year);

		//check speed validity
		if (maxSpeed > 0) {
			this.maxSpeed = maxSpeed;
		} else {
			throw new SpeedException("Max speed must be greater than 0!");
		}
		
		this.engineDisplacement = engineDisplacement;
		
	}
	
	//calculate driving time based on a given distance
	public double calculateDrivingTime(double distance) {
		
		double P = 0.6 + Math.random() * 0.2;
		
		return distance / (maxSpeed * P);
		
	}

}
