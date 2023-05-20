import Interfaces.Comparable;


public class Customer extends Person implements Comparable<Customer>{

	private double total_payments;

	//constructor
	public Customer (int ID, String name, int age, char gender) {
		super(ID,name, age, gender);
		total_payments = 10;
	}


	//getters
	public double payments() {
		return total_payments;
	}

	public int age() {
		return age;
	}


	public int giveRating() {	
		double rating = (Math.random() * 5) + 1;
		return (int)rating;
	}


	public double pay(double time, double Fare) {
		double to_pay = 2 * time + Fare ;
		total_payments += to_pay;
		return to_pay;
	}


	// compare functions
	public int compareTo(Customer other) {
		if (total_payments == other.payments()) {
			return 0;
		}
		else if (total_payments > other.payments()) {
			return 1;
		} else {
			return -1;
		}
	}

	public int compareAgeTo(Customer other) {
		return this.age - other.age();
	}

}
