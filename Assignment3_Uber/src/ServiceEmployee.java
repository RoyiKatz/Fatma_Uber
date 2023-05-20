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
		bonus_multiplier = 2;

	}


	//getters
	public int totalBonus() {
		return total_bonus;
	}
	
	public boolean upgraded() {
		return upgraded;
	}

	public String serviceArea() {
		return service_area;
	}

	
	//update bonus
	private void getBonus(int rating) {
		total_bonus += bonus_multiplier * rating;
	}
	
	
	//func that gets a vehicle and pairs it with a driver
	private Driver pairDriverTo(Vehicle vehicle) {
		
		for (Driver d : Company.available_drivers) {
			if (d.licenseMatch(vehicle)) {
				vehicle.addDriver(d);
				Company.available_drivers.remove(d);
				return d;
			}
		}
		return null;
		
	}


	public void Service(ServiceCall sc) {

		// welcome message
		System.out.println("GetFatmaUber is here for you!");

		//only if we're in the service area
		if (service_area.equals(sc.serviceArea())) {
	
			Vehicle vehicle = sc.vehicle();

			
			//find and pair driver
			Driver driver = pairDriverTo(vehicle);
			
			//if there isn't a driver
			if(driver == null) {
				System.out.println("Unfortunately we don't have a driver nearby.");
				return;
			}
			
			
			//print driver and vehicle details
			System.out.println("Driver name: " + driver);
			System.out.println("License number: " + vehicle.licenseNumber());
			System.out.println("Model: " + vehicle.model());
			
			
			//calculate driving time
			double time = vehicle.calculateDrivingTime(sc.distance());
			System.out.println("Duration: " + time);
			
			//calculate fare, update driver profit, driver rating
			double fare = driver.drivingProfit(sc.customer(), time, vehicle);
			System.out.println("Payment: " + fare);
			
			// update employee rating, and employee bonus
			int rating = sc.customer().giveRating();
			rate(rating);
			getBonus(rating);
			
			System.out.println("Enjoy!");
			
			//return the driver to available list
			Company.available_drivers.add(driver);
			vehicle.removeDriver();
			
		} else {
			System.out.println("Requested service area is out of range.");
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
