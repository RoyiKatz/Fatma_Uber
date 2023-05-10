import Interfaces.Upgradable;

public class PremiumTaxi extends Taxi implements Upgradable {

	private boolean upgraded;
	
	// constructor
	public PremiumTaxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers) {
		super(licenseNumber, model, year, baseFare, maxPassengers);
		is_deliverable = false;
		upgraded = false;
	}

	
	// validate max passengers number
	protected boolean validPassengers(int maxPassengers) {
		return maxPassengers >= 1 && maxPassengers <= 10;
	}
	
	
	//getter
	public boolean upgraded() {
		return upgraded;
	}

	
	// upgrade interior
	public boolean upgrade() {
		
		double chance = Math.random();
		
		if (chance <0.5) {
			System.out.println("Taxi " + licenseNumber + " just got upgraded, enjoy!");
			upgraded = true;
			return true;
		} else {
			return false;
		}
	}
}
