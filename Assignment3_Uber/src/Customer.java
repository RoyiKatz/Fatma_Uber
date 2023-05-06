
public class Customer extends Person implements Comparable<Customer>{
	
	private int fare;
	
	//constructor
	public Customer (int ID, String name, int age, char gender) {
		super(ID,name, age, gender);
		fare = 10;
	}
	
	//getter
	public int fare() {
		return fare;
	}
	
	public int giveRating() {
		double p = 5 + Math.random() * 1;
		int ratingnum = (int)p;
		return ratingnum;
	}
	
	public double pay(double time, double Fare) {
		double sum_Expense = 2 * time + Fare ;
		fare += sum_Expense;
		return sum_Expense;
	}
	
	public int compareTo(Customer other) {
		return this.fare - other.fare();
	}

}
