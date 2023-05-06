
public class Driver extends Person {
	 protected String phoneNumber;
	protected double rating;
	protected String [] licenses;
	protected Customer customer;
public Driver(int ID, String name, String phoneNumber , double rating, String [] licenses) {
super(ID,name);
	this.phoneNumber=phoneNumber;
	this.rating=rating;
this.licenses= new String [licenses.length]	;
for(int i=0;i<licenses.length;i=i+1) {
	
	if (licenses[i].equals("A")) {
		this.licenses[i]= “A”;
	}
	this.licenses[i]=“B”;
	}
}

public double drivingProfit(Customer c, int time, Vehicle v) {
	 double p=  1 + Math.random() * 0.5;
	 double sum= c.giveRating()+c.sum_Expense-time*p;
	 this.rating=this.rating+c.giveRating();
	return sum;

}

public int compareTo(Object other) {
	if( this.rating > ((Driver)other).rating())
		return 1;
	if( this.rating< ((Driver)other).rating())
		return -1;
	return 0;


}
}