import Exceptions.GenderExecption;


public abstract class Person implements Comparable<Person>{

	protected int ID;
	protected String name;
	protected int age;
	protected char gender;


	//constructors
	public Person(int ID, String name) {
		this.ID = ID;
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

	public abstract int compareTo(Person other);

}
