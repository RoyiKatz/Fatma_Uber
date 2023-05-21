import Interfaces.Upgradable;

public class PremiumTaxi extends Taxi implements Upgradable {

	private boolean upgraded;
	private double luxury_charge;
	
	// constructor
	public PremiumTaxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers, double luxuryCharge) {
		super(licenseNumber, model, year, baseFare, maxPassengers);
		is_deliverable = false;
		upgraded = false;
		luxury_charge = luxuryCharge;
	}

	
	// validate max passengers number
	protected boolean validPassengers(int maxPassengers) {
		return maxPassengers >= 1 && maxPassengers <= 10;
	}
	
	
	//getters
	public boolean upgraded() {
		return upgraded;
	}
	
	protected String getType() {
		return "Premium Taxi";
	}
	
	public double luxuryCharge() {
		return luxury_charge;
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
