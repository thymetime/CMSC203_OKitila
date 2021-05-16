
public class Smoothie extends Beverage {

	boolean proteinPowder;
	int fruits;
	
	public Smoothie(String n, TYPE.type t, SIZE.size s, int f, boolean p) {
		super(n, t, s);
		this.fruits = f;
		this.proteinPowder = p;
		// TODO Auto-generated constructor stub
	}
	
	public Smoothie(String n, SIZE.size s, int f, boolean p) {
		super(n, TYPE.type.SMOOTHIE, s);
		this.fruits = f;
		this.proteinPowder = p;
		// TODO Auto-generated constructor stub
	}

	@Override
	double calcPrice() {
		double bevPrice = basePrice;
		
		if (this.beverageSize == SIZE.size.MEDIUM)
			bevPrice += sizePrice;
		
		if (this.beverageSize == SIZE.size.LARGE)
			bevPrice += (2 * sizePrice);
		
		if (proteinPowder)
			bevPrice += 1.50;
		
		bevPrice += (fruits * 0.50);
		
		return bevPrice;
	}

	public String toString() {
		return super.toString() + ", Fruits: " + this.fruits + ", Protein Powder: " + this.proteinPowder + ", Price: " + this.calcPrice();
	}
	
	public boolean equals(Smoothie bev) {
		boolean equal = false;
		
		if (super.equals(bev) &&
			(this.fruits == bev.fruits) &&
			(this.proteinPowder == bev.proteinPowder)
			)
			return true;
		
		return equal;
	}

	public boolean getProteinPowder() {
		return proteinPowder;
	}

	public void setProteinPowder(boolean proteinPowder) {
		this.proteinPowder = proteinPowder;
	}

	public int getFruits() {
		return fruits;
	}

	public void setFruits(int fruits) {
		this.fruits = fruits;
	}
	
	public double getBasePrice() {
		return this.basePrice;
	}

	
	
}
