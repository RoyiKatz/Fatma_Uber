
public abstract class Employee extends Person {

	protected double rating;
	
	// constructors
	public Employee(int ID, String name) {
		super(ID, name);
	}
	
	public Employee (int ID, String name, int age, char gender) {
		super(ID, name, age, gender);
	}
	
	
	// getters
	public double rating() {
		return rating;
	}

}
