

public class ServiceCall {

	private Customer costumer;
	private Vehicle vehicle;
	private String area;
	private double distance;
	
	//constructor
	public ServiceCall (Customer c, Vehicle v, String serviceArea, double distance) {
		
		costumer = c;
		vehicle = v;
		area = serviceArea;
		this.distance = distance;
	}
}
