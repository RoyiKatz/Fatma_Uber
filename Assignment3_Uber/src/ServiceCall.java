

public class ServiceCall {

	private Customer customer;
	private Vehicle vehicle;
	private String area;
	private double distance;
	
	//constructor
	public ServiceCall (Customer c, Vehicle v, String serviceArea, double distance) {
		
		customer = c;
		vehicle = v;
		area = serviceArea;
		this.distance = distance;
	}
	
	//getters
	public String serviceArea() {
		return area;
	}
	
	public Customer customer() {
		return customer;
	}
	
	public Vehicle vehicle() {
		return vehicle;
	}

	public double distance() {
		return distance;
	}
}
