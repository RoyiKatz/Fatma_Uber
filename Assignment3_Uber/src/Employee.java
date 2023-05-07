
public abstract class Employee extends Person {

	protected double rating;
	
	// constructors
	public Employee(int ID, String name, double rating) {
		super(ID, name);
		this.rating = rating;
	}
	
	public Employee (int ID, String name,double rating, int age, char gender) {
		super(ID, name, age, gender);
		this.rating = rating;
	}
	
	
	// getters
	public double rating() {
		return rating;
	}

}
