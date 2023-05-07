
public class Customer extends Person implements Comparable<Customer>{
	
	private double fare;
	
	//constructor
	public Customer (int ID, String name, int age, char gender) {
		super(ID,name, age, gender);
		fare = 10;
	}
	
	//getter
	public double fare() {
		return fare;
	}
	
	public int age() {
		return age;
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
	
	// compare functions
	public int compareTo(Customer other) {
		if (this.fare == other.fare()) {
			return 0;
		}
		else if (this.fare > other.fare()) {
			return 1;
		} else {
			return -1;
		}
	}

	
	public int compareAgeTo(Customer other) {
		return this.age - other.age();
	}
	
}
