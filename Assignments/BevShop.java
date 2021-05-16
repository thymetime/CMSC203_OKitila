import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	int numAlcholicDrinks;
	final int minYearAlcohol = 21;
	
	ArrayList<Order> orders = new ArrayList<Order>();
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Order o : orders)
			s.append(o.toString() + ", ");
		s.append("Total Monthly Sale: " + this.totalMonthlySale());
		return s.toString();
	}
	
	@Override
	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME)
			return true;
		return false;
	}

	@Override
	public boolean eligibleForMore() {
		if (getCurrentOrder().findNumOfBeveType(TYPE.type.ALCOHOL) >= MAX_ORDER_FOR_ALCOHOL)
			return false;
		return true;
	}

	@Override
	public boolean validAge(int age) {
		if (age > MIN_AGE_FOR_ALCOHOL)
			return true;
		return false;
	}

	@Override
	public void startNewOrder(int time, DAY.day day, String customerName, int customerAge) {
		Customer c = new Customer(customerName, customerAge);
		Order order = new Order(Order.randNum(), time, day, c);
		orders.add(order);
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE.size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE.size size) {
		getCurrentOrder().addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE.size size, int numOfFruits, boolean addProtien) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++)
			if (orders.get(i).orderNum == orderNo)
				return i;
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;
		
		for (Order o : orders)
			total += o.calcOrderTotal();
		
		return total;
	}
	
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public void sortOrders() {	  

		for (int i = 0; i < orders.size()-1; i++)
	        {
	            // Find the minimum element in unsorted array
	            int min_idx = i;
	            for (int j = i+1; j < orders.size(); j++)
	                if (orders.get(j).orderNum < orders.get(min_idx).orderNum)
	                    min_idx = j;
	  
	            // Swap the found minimum element with the first
	            // element
	            Order temp = orders.get(min_idx);
	            orders.set(min_idx, orders.get(i));// = orders.get(i);
	            orders.set(i, temp);
	        }

	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
		
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public int getNumOfAlcoholDrink() {
		return getCurrentOrder().findNumOfBeveType(TYPE.type.ALCOHOL);
	}

	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > 5)
			return true;
		return false;
	}



}
