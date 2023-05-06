
public class Customer extends Person implements Comparable{
	protected int age;
	protected char gender;
	public static int $10 ;
	protected int sum_Expense;
	//constructor
	public Customer (int ID, String name, int age, char gender) {
		super(ID,name);
		this.age=age;
		this.gender=gender;
	}
	public int giveRating() {
		double p = 5 + Math.random() * 1;
		int ratingnum= (int)p;
		return ratingnum;
	}
	public double pay(double time, double Fare) {
		 double sum_Expense=2*time + Fare ;
		return sum_Expense;
	}
	public int compareTo(Object other) {

		if( double pay(double pay,double Fare)>((Customer)other).double pay ) {
			return 1;
		}
			
		if(this.age < ((Customer)other).age ) {
			return -1;
		}
		return 0;

	}
	// compare to - לא לשכוח 

}
