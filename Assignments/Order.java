import java.util.ArrayList;
import java.math.*;

public class Order implements OrderInterface, Comparable{
	
//	•	Instance variables for  order number, order time, order day and customer and a list of beverages within this order
//	•	A method to generate a random number within the range of 10000 and 90000
//	•	A parametrized constructor 
//	•	A method called addNewBeverage that adds a beverage to the order.  This is an overloaded method to add different beverages to the order.  Refer to the interface OrderInterface provided for you,
//	•	An Overridden toString method: Includes order number, time, day, customer name , customer age and the list of beverages (with information of the beverage).
//	•	Override the compareTo method to compare this order with another order based on the order number. Returns 0 if this order number is same as another order's order number, 1 if it is greater than another order's order number, -1 if it smaller than another order's order number.
//	•	getters and setters  and any other methods that are needed for your design.   Note: The getter method for the customer returns a Deep copy of the customer.
//	•	Refer to provided OrderInterface interface for additional methods.
//	•	

	int orderNum;
	int orderTime;
	

	DAY.day orderDay;
	Customer customer;
	ArrayList<Beverage> bevList = new ArrayList<Beverage>();

	public Order(int num, int time, DAY.day day, Customer customer) {
		this.orderNum = num;
		this.orderTime = time;
		this.orderDay = day;
		this.customer = customer;
	}
	
//Includes order number, time, day, customer name , customer age and the list of beverages (with information of the beverage).

	public Order(int i, DAY.day day, Customer customer) {
		this.orderNum = i;
		this.orderDay = day;
		this.customer = customer;	}

	public String toString() {
		StringBuilder s = new StringBuilder("Order #" + orderNum + ", Time: " + orderTime + ", Customer: " + customer.toString());
		for (Beverage b : bevList) 
			s.append(b.toString() + ", ");
		
		s.append("Order Total: " + this.calcOrderTotal());
		
		return s.toString();
	}

	public int getTotalItems() {
		return bevList.size();
	}

	public boolean isWeekend() {
		boolean weekend = false;
		
		if (orderDay == DAY.day.SATURDAY || orderDay == DAY.day.SUNDAY)
			weekend = true;
		
		return weekend;
	}

	public double calcOrderTotal() {
		double total = 0;
		
		for (Beverage b : bevList)
			total += b.calcPrice();
		
		return total;
	}

	@Override
	public int compareTo(Order o) {
		if (this.orderNum > o.orderNum)
			return 1;
		else if (this.orderNum == o.orderNum)
			return 0;
		else
			return -1;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		if (bevList.isEmpty())
			return null;
		return bevList.get(itemNo);
	}

	@Override
	public int findNumOfBeveType(TYPE.type type) {
		int num = 0;
		
		for (Beverage b : bevList)
			if (b.beverageType == type)
				num++;
		
		return num;
	}

	@Override
	public void addNewBeverage(String bevName, SIZE.size size, boolean extraShot, boolean extraSyrup) {
		Beverage coffeeBev = new Coffee(bevName, TYPE.type.COFFEE, size, extraShot, extraSyrup);
		bevList.add(coffeeBev);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE.size size) {

		Beverage alcoholBev = new Alcohol(bevName, TYPE.type.ALCOHOL, size, isWeekend());
		bevList.add(alcoholBev);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE.size size, int numOfFruits, boolean addPRotien) {
		Beverage smoothieBev = new Smoothie(bevName, TYPE.type.SMOOTHIE, size, numOfFruits, addPRotien);
		bevList.add(smoothieBev);		
	}
	
	public static int randNum() {
		return (int) (Math.floor(Math.random() * 80001) + 10000);
	}

	@Override
	public int compareTo(Object o) {
		System.out.println("Incorrect compareTo method used");
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public DAY.day getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(DAY.day orderDay) {
		this.orderDay = orderDay;
	}
	
	public Customer getCustomer() {
		Customer c = new Customer(this.customer);
		return c;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



}
