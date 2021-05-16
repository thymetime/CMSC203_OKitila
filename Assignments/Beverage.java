
abstract class Beverage {
//	•	Instance variables for beverage name, beverage type, size, and constant attributes for the base price ($2.0) and size price (additional $1 to go a size up).
//	•	A parametrized constructor to create a Beverage object given its name, type and  size
//	•	An abstract methods called calcPrice that calculates and returns the beverage price. 
//	•	An Overridden  toString method: String representation for Beverage including the name and size
//	•	An Overridden  equals method: checks equality based on name, type, size of the beverage
//	•	getters and setters  and any other methods that are needed for your design.  
//	•	Use finals to represent constants.
	
	String name;
	TYPE.type beverageType;
	protected SIZE.size beverageSize;
	final double basePrice = 2.00, sizePrice = 1.00;
	
	public Beverage(String n, TYPE.type t, SIZE.size s) {
		this.name = n;
		this.beverageType = t;
		this.beverageSize = s;
	}
	
	abstract double calcPrice ();
	
	public String toString() {
		return "Beverage: " + this.name + ", Size: " + this.beverageSize;
	}
	
	public boolean equals(Beverage bev) {
		boolean equal = false;
		
		if (this.name.equals(bev.name) &&
			this.beverageSize.equals(bev.beverageSize) &&
			this.beverageType.equals(bev.beverageType)
			)
			equal = true;
		
		return equal;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TYPE.type getBeverageType() {
		return beverageType;
	}

	public void setBeverageType(TYPE.type beverageType) {
		this.beverageType = beverageType;
	}

	public SIZE.size getBeverageSize() {
		return beverageSize;
	}

	public void setBeverageSize(SIZE.size beverageSize) {
		this.beverageSize = beverageSize;
	}
	

}
