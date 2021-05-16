
public class Coffee extends Beverage {

//	•	Contains additional instance variables of type boolean to indicate if it contains extra shot of coffee (additional cost of 50 cents) and extra syrup (additional cost of 50 cents).   
//	•	A parametrized constructor  
//	•	An Overridden  toString method: String representation of Coffee beverage, including the name , size ,  whether it contains extra shot, extra syrup and the price of the coffee
//	•	An Overridden calcPrice method.
//	•	An Overridden  equals method: checks equality based on the Beverage class equals method and additional instance variables for this class.
//	•	getters and setters  and any other methods that are needed for your design.
//	•	Use finals to represent constants.

	boolean extraShot, extraSyrup;
	
	public Coffee (String n, TYPE.type t, SIZE.size s, boolean shot, boolean syrup) {
		super(n, t, s);
		this.extraShot = shot;
		this.extraSyrup = syrup;
		// TODO Auto-generated constructor stub
	} 
	
	public Coffee (String n, SIZE.size s, boolean shot, boolean syrup) {
		super(n, TYPE.type.COFFEE, s);
		this.extraShot = shot;
		this.extraSyrup = syrup;
		// TODO Auto-generated constructor stub
	} 

	public String toString() {
		return super.toString() + ", Extra shot?: " + extraShot + ", Extra syrup?: " + extraSyrup + ", Price: " + this.calcPrice();
	}
	

	public boolean equals(Coffee bev) {
		boolean equal = false;
		
		if (super.equals(bev) &&
			(this.extraShot == bev.extraShot) &&
			(this.extraSyrup == bev.extraSyrup)
			)
			return true;
			
		
		return equal;
	}
	
	public double calcPrice() {
		double bevPrice = basePrice;
		
		if (this.beverageSize == SIZE.size.MEDIUM)
			bevPrice += sizePrice;
		
		if (this.beverageSize == SIZE.size.LARGE)
			bevPrice += (2 * sizePrice);
		
		if (extraShot)
			bevPrice += 0.50;
		
		if (extraSyrup)
			bevPrice += 0.50;
		
		return bevPrice;
	}

	public boolean getExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	
	public double getBasePrice() {
		return this.basePrice;
	}

	
}
