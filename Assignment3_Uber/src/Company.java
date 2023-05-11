import java.util.Vector;
import Interfaces.*;
import Interfaces.Comparable;

public class Company {
	static Vector <Customer> customers;
	static Vector <Vehicle> vehicles;
	static Vector <Driver> drivers;
	static Vector <ServiceEmployee> serivce_employees;


	//constructor
	public Company() {
		customers = new Vector<Customer>();	
		vehicles = new Vector<Vehicle>();
		serivce_employees = new Vector<ServiceEmployee>();
		drivers = new Vector<Driver>();
	}


	//adding elements to lists
	public void addCustomer(Customer c) {
		customers.add(c);
	} 

	public void addVehicle(Vehicle v) {
		vehicles.add(v); 
	}

	public void addSerivceEmployee(ServiceEmployee se) {
		serivce_employees.add(se); 
	}

	public void addDriver(Driver driver) {
		drivers.add(driver);	
	}


	//search for a customer base on id
	public boolean findCustomer(int id) {
		for (Customer c: customers) {
			if (c.id() == id) {
				return true;
			}
		}
		return false;
	}


	//check service validity
	public boolean validService(String input) {
		String[] services = {"delivery", "taxi", "premium taxi"};
		for (String service: services) {
			if (input.toLowerCase() == service) {
				return true;
			}
		}
		return false;
	}


	public boolean serviceForCustomer(int customerID, String serviceType, String serviceArea, double distance) {

		//check if customer exists in database		
		if (!findCustomer(customerID)) {
			return false;
		}

		//check if the service type is valid
		if (!validService(serviceType)) {
			return false;
		}

		//check if there's no vehicles or drivers
		if (vehicles.isEmpty() || drivers.isEmpty()) {
			return false;
		}

		//find the employee with the lowest bonus
		ServiceEmployee worker = getMin(serivce_employees);

		//create a new service call


		return true;
	}


	public static double totalRevenues() {
		double total = 0;

		for (Driver d: drivers) {
			total += d.profit();
		}
		return total;
	}


	public static double avgCustomerPayment() {
		double total = 0;
		for (Customer c: customers) {
			total += c.payments();
		}
		return customers.isEmpty()? 0 : total / customers.size();
	}


	public static <T extends Comparable<? super T>> T getMin(Vector<T> comparables){
		T min = comparables.elementAt(0);
		for (T other: comparables) {
			if (min.compareTo(other) < 0) {
				min = other;
			}
		}

		return min;
	}



	public static int upgrades(Vector<Upgradable> lst) {

		int count = 0;
		for (Upgradable item: lst) {
			if(item.upgraded()) {
				count++;
			}
		}
		return count;

	}
	
	
	public static void DeliveryVehicles() {
		for (Vehicle v: vehicles) {
			if(v.is_deliverable) {
				System.out.println(v);
			}
		}
	}

}

