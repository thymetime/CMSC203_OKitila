
public class Alcohol extends Beverage {

	boolean isWeekend;
	
	public Alcohol(String n, TYPE.type t, SIZE.size s, boolean w) {
		super(n, t, s);
		this.isWeekend = w;
		// TODO Auto-generated constructor stub
	}
	
	public Alcohol(String n, SIZE.size s, boolean w) {
		super(n, TYPE.type.ALCOHOL, s);
		this.isWeekend = w;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return super.toString() + "Offered in weekend: " + isWeekend + ", Price: " + this.calcPrice();
	}
	
	public boolean equals(Alcohol bev) {
		boolean equal = false;
		
		if (super.equals(bev) &&
			(this.isWeekend == bev.isWeekend)
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
		
		if (isWeekend)
			bevPrice += 0.60;
		
		
		return bevPrice;
	}

	public boolean isWeekend() {
		return isWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
	
	public double getBasePrice() {
		return this.basePrice;
	}
}
