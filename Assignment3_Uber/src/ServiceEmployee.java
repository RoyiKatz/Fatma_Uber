import Interfaces.Comparable;
import Interfaces.Upgradable;

public class ServiceEmployee extends Employee implements Comparable<ServiceEmployee>, Upgradable{

	private String service_area;
	private int total_bonus;
	
	
	//constructor
	public ServiceEmployee (int ID, String Name, double rating, int age, char gender, String serviceArea) {
		
		super(ID, Name, rating, age, gender);
		service_area = serviceArea;
		total_bonus = 0;
		
	}
	
	
	//getters
	public int totalBonus() {
		return total_bonus;
	}
	
	
	//update bonus
	private void getBonus(double rating) {
		total_bonus += 2 * rating;
	}
	
	
	public void Service(ServiceCall sc) {
		
		// welcome message
		System.out.println("GetFatmaUber is here for you!");
		
		if (service_area == sc.serviceArea()) {
			
			// search for vehicle
			
			// search for correct driver
			
			// update bonus
			getBonus(sc.customer().giveRating());
		}
		
	}


	public int compareTo(ServiceEmployee other) {
		return this.total_bonus - other.totalBonus();
	}


	public boolean upgrade() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
