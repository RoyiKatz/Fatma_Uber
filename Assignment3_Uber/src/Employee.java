
public abstract class Employee extends Person {

	protected double rating;
	protected int total_customers;
	
	// constructors
	public Employee(int ID, String name, double rating) {
		super(ID, name);
		this.rating = rating;
		total_customers = 0;
	}
	
	public Employee (int ID, String name,double rating, int age, char gender) {
		super(ID, name, age, gender);
		this.rating = rating;
	}
	
	
	// getter
	public double rating() {
		return rating;
	}
	
	
	//accepting a customer and updating rating
	public void rate(int rating) {
		total_customers++;
		this.rating = ((this.rating * (total_customers - 1)) + rating) / total_customers;
	}

}
