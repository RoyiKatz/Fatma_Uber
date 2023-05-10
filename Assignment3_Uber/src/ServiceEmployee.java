import Interfaces.Comparable;
import Interfaces.Upgradable;

public class ServiceEmployee extends Employee implements Comparable<ServiceEmployee>, Upgradable{

	private String service_area;
	private int total_bonus, bonus_multiplier;	//bonus related variables
	int last_checked_customers;
	private boolean upgraded;


	//constructor
	public ServiceEmployee (int ID, String Name, double rating, int age, char gender, String serviceArea) {

		super(ID, Name, rating, age, gender);
		service_area = serviceArea;
		total_bonus = 0;
		last_checked_customers = 0;
		upgraded = false;

	}


	//getters
	public int totalBonus() {
		return total_bonus;
	}
	
	public boolean upgraded() {
		return upgraded;
	}


	//update bonus
	private void getBonus(int rating) {
		total_bonus += bonus_multiplier * rating;
	}


	public void Service(ServiceCall sc) {

		// welcome message
		System.out.println("GetFatmaUber is here for you!");

		if (service_area == sc.serviceArea()) {

			// search for vehicle and driver
			
			System.out.println("Driver name: ");
			System.out.println("License number: ");
			System.out.println("Model: ");

			// add driver to vehicle
			
			//calculate driving time
			System.out.println("Duration: ");
			
			//calculate fare
			System.out.println("Payment: ");
			
			//update driver profit, driver and employee rating, and employee bonus

			
			System.out.println("Enjoy!");
		}

	}


	public int compareTo(ServiceEmployee other) {
		return this.total_bonus - other.totalBonus();
	}


	public boolean upgrade() {
		//if number of calls doubled since last check
		if (total_customers >= last_checked_customers * 2) {
			//update number of calls
			last_checked_customers = total_customers;
			
			//update bonus multiplier
			if (bonus_multiplier <= 8) {
				bonus_multiplier *= 2;
				upgraded = true;
				return true;
			}
		}	
		return false;
	}

}
