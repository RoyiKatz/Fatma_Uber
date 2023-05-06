import Interfaces.Upgradable;

public class PremiumTaxi extends Taxi implements Upgradable {

	// constructor
	public PremiumTaxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers) {
		super(licenseNumber, model, year, baseFare, maxPassengers);
	}

	
	// validate max passengers number
	protected boolean validPassengers(int maxPassengers) {
		return maxPassengers >= 1 && maxPassengers <= 10;
	}

	
	// upgrade interior
	public boolean upgrade() {
		
		double chance = Math.random();
		
		if (chance <0.5) {
			System.out.println("Taxi " + licenseNumber + " just got upgraded, enjoy!");
			return true;
		} else {
			return false;
		}
	}
}
