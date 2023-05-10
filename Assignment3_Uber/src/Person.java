import Exceptions.GenderExecption;


public abstract class Person{

	protected int id;
	protected String name;
	protected int age;
	protected char gender;


	//constructors
	public Person(int ID, String name) {
		this.id = ID;
		this.name = name;
	}

	public Person(int ID, String name, int age, char gender) {

		this(ID, name);
		this.age = age;
		if (gender == 'M' || gender == 'F' || gender == 'U') {
			this.gender = gender;
		} else {
			throw new GenderExecption("invalid gender. must be 'M', 'F' or 'U'.");
		}
		
	}
	
	//getters
	public int id() {
		return id;
	}
	
	
}
