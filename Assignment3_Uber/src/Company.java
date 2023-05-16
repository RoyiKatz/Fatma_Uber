import java.util.Vector;
import Interfaces.*;
import Interfaces.Comparable;

public class Company {
	public Vector <Customer> customers;
	public static Vector <Vehicle> vehicles;
	public static Vector <Driver> drivers;
	public Vector <ServiceEmployee> serivce_employees;
	public Vector<ServiceCall> calls;


	//constructor
	public Company() {
		customers = new Vector<Customer>();	
		vehicles = new Vector<Vehicle>();
		serivce_employees = new Vector<ServiceEmployee>();
		drivers = new Vector<Driver>();
		calls = new Vector<ServiceCall>();
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
	public Customer findCustomer(int id) {
		for (Customer c: customers) {
			if (c.id() == id) {
				return c;
			}
		}
		return null;
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


	//func that gets a service and returns a vector of appropriate vehicles
	private Vector<Vehicle> serviceVehicles(String service) {
		Vector<Vehicle> v_list = new Vector<Vehicle>();
		for (Vehicle v: vehicles) {
			if (inService(v, service)) {
				v_list.add(v);
			}
		}
		return v_list;
	}


	//func that gets a vehicle and a service type and checks whether the vehicle is in that service
	private boolean inService(Vehicle v, String s) {
		switch (s) {
		case "Delivery":
			return v.isDeliverable();
		case "Taxi":
			return v instanceof Taxi;
		case "Premium Taxi":
			return v instanceof PremiumTaxi;
		}
		//default
		return false;
	}

	
	/*func that gets a vector of vehicles and tries to pair a vehicle with a driver. if successful it'll
 		return the vehicle. if not it'll return null */
	private Vehicle findVehicle(Vector<Vehicle> vehicles) {
		
		for (Vehicle v : vehicles) {
			if (pairDriver(v)) {
				return v;
			}
		}
		return null;
		
	}
	

	// func that gets a vehicle and tries to pair a driver to it
	private boolean pairDriver(Vehicle v) {
		for(Driver d: drivers) {
			if (d.licenseMatch(v)) {
				v.addDriver(d);
				return true;
			}
		}
		return false;
	}


	//func that gets a service area and returns a vector of service employees in that area
	private Vector<ServiceEmployee> employeesWithinArea(String area){
		Vector<ServiceEmployee> employees = new Vector<ServiceEmployee>();
		for (ServiceEmployee se : serivce_employees) {
			if (se.serviceArea() == area) {
				employees.add(se);
			}
		}
		return employees;
	}


	public boolean serviceForCustomer(int customerID, String serviceType, String serviceArea, double distance) {

		//check if customer exists in database		
		if (findCustomer(customerID) == null) {
			System.out.println("Could not find customer.");
			return false;
		}

		//check if the service type is valid
		if (!validService(serviceType)) {
			System.out.println("We do not provide that service, sorry :(");
			return false;
		}

		//list all the employees in the area
		Vector<ServiceEmployee> in_area = employeesWithinArea(serviceArea);
		
		//if there's no employees in the area
		if (in_area.isEmpty()) {
			System.out.println("No service employees in that area.");
			return false;
		}

		//find the employee with the lowest bonus
		ServiceEmployee worker = getMin(in_area);

		//list all vehicles in service
		Vector<Vehicle> in_service = serviceVehicles(serviceType);
		
		//find a vehicle that has a driver and pair them
		Vehicle available = findVehicle(in_service);
		
		//if there's no available vehicle or driver
		if (available == null) {
			System.out.println("We dont have a vehicle or driver available at the moment.");;
			return false;
		}

		//create a new service call
		ServiceCall call = new ServiceCall(findCustomer(customerID), available, serviceArea, distance);
		calls.add(call);
		
		//get worker to handle call
		System.out.println("Employee to handle call: " + worker.name());
		
		worker.Service(call);

		return true;
	}


	public static double totalRevenues(Vector<Driver> drivers) {
		double total = 0;

		for (Driver d: drivers) {
			total += d.profit();
		}
		return total;
	}


	public static double avgCustomerPayment(Vector<Customer> customers) {
		double total = 0;
		for (Customer c: customers) {
			total += c.payments();
		}
		return customers.isEmpty()? 0 : total / customers.size();
	}


	public static <T extends Comparable<T>> T getMin(Vector<T> comparables){
		T min = comparables.elementAt(0);
		for (T other: comparables) {
			if (min.compareTo(other) > 0) {
				min = other;
			}
		}

		return min;
	}


	public static int upgrades(Vector<? extends Upgradable> lst) {

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

