

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


	public double drivingProfit(Customer c, int time, Vehicle v) {
		
		double p =  1 + Math.random() * 0.5;
				
		double sum = c.giveRating() + c.pay(time,v.baseFare()) - (time * p);
		
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