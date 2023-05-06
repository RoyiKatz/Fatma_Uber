
public class ServiceEmployee extends Person {

	private double rating;
	private int age;
	private char gender;
	private String service_area;
	
	
	//constructor
	public ServiceEmployee (int ID, String Name, double rating, int age, char gender, String serviceArea) {
		
		super(ID, Name, age, gender);
		
		this.rating = rating;
		service_area = serviceArea;
		
	}
	
	public void Service(ServiceCall sc) {
		
	}
	
}
