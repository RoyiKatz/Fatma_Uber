
public  abstract class Person implements Comparable<Person>{
	
	protected int ID;
	protected String name;
	
	public Person(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
	public abstract int compareTo(Person other);

}
