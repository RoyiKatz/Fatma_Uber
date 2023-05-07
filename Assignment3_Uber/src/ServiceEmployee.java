import Interfaces.Comparable;
import Interfaces.Upgradable;

public class ServiceEmployee extends Employee implements Comparable<ServiceEmployee>, Upgradable{

	private String service_area;
	
	private int bonus;
	
	
	//constructor
	public ServiceEmployee (int ID, String Name, double rating, int age, char gender, String serviceArea) {
		
		super(ID, Name, age, gender);
		
		this.rating = rating;
		service_area = serviceArea;
		bonus = 0;
		
	}
	
	//getters
	public int bonus() {
		return bonus;
	}
	
	public void Service(ServiceCall sc) {
		
		// welcome message
		System.out.println("GetFatmaUber is here for you!");
		
		if (service_area == sc.serviceArea()) {
			
			// search for vehicle
			
			// search for correct driver
			
			// update bonus
		}
		
	}

	@Override
	public int compareTo(ServiceEmployee other) {
		return this.bonus - other.bonus();
	}

	@Override
	public boolean upgrade() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
