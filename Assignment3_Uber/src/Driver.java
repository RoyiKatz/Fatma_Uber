import Exceptions.LicenseMismatchExeption;
import Interfaces.Comparable;


public class Driver extends Employee implements Comparable<Driver>{

	private String phoneNumber;
	private String[] licenses;
	private double total_profit;

	//constructor
	public Driver(int ID, String name, String phoneNumber , double rating, String [] licenses) {

		super(ID, name, rating);

		this.phoneNumber = phoneNumber;
		this.licenses = new String [licenses.length];
		for(int i = 0; i < licenses.length; i++) {
			this.licenses[i] = licenses[i];
		}

		total_profit = 0;

	}


	//getters
	public double profit() {
		return total_profit;
	}
	
	public String phoneNumber() {
		return phoneNumber;
	}


	public double drivingProfit(Customer c, double time, Vehicle v) {
		
		//check license against car
		if (!licenseMatch(v)) {
			throw new LicenseMismatchExeption("License incompatible with vehicle!");
		}

		double p =  1 + Math.random() * 0.5;

		int customer_rating = c.giveRating();

		double sum = customer_rating + c.pay(time,v.baseFare()) - (time * p);

		//update rating
		rate(customer_rating);
		//update total profit
		total_profit += sum;

		return sum;

	}

	//func that gets a vehicle and returns true if the license is incompatible
	public boolean licenseMatch(Vehicle v) {
		boolean compatible = false;
		if (v instanceof Motorcycle) {
			for (String license: this.licenses) {
				if (license == "A") {
					compatible = true;
				}
			}
		} else {
			for (String license: this.licenses) {
				if (license == "B") {
					compatible = true;
				}
			}
		}
		return compatible;
	}


	public int compareTo(Driver other) {
		if(this.rating > other.rating())
			return 1;
		if(this.rating < other.rating())
			return -1;
		return 0;
	}

}