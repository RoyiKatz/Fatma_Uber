

public class Driver extends Person implements Comparable<Driver>{

	protected String phoneNumber;
	protected double rating;	// avg of the ratings
	protected String [] licenses;
	private double total_profit;

	//constructor
	public Driver(int ID, String name, String phoneNumber , double rating, String [] licenses) {
		
		super(ID,name);

		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.licenses = new String [licenses.length];
		for(int i = 0; i < licenses.length; i++) {
			this.licenses[i] = licenses[i];
		}
		
		total_profit = 0;
		
	}
	
	//getter
	public double rating() {
		return rating;
	}

	public double drivingProfit(Customer c, int time, Vehicle v) {
		
		double p =  1 + Math.random() * 0.5;
		
		double fare = (v instanceof Taxi) ? ((Taxi)v).baseFare() : 0;
		
		double sum = c.giveRating() + c.pay(time,fare) - (time * p);
		
		//update rating
		
		//update total profit
		total_profit += sum;
		
		return sum;

	}

	public int compareTo(Driver other) {
		if(this.rating > other.rating())
			return 1;
		if(this.rating < other.rating())
			return -1;
		return 0;
	}
}