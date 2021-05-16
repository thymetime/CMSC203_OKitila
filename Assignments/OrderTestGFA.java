import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTestGFA {
	Order r1,r2,r3,r4;
	@Before
	public void setUp() throws Exception {
		r1 = new Order (8, DAY.day.MONDAY, new Customer ("Mary", 22));
		r2 = new Order (12, DAY.day.SATURDAY, new Customer ("John", 45));
		r3 = new Order (10, DAY.day.SUNDAY, new Customer ("Kate", 21));
	}

	@After
	public void tearDown() throws Exception {
		r1=r2=r3=null;
	}
	
	@Test 
	public void testGetBeverage( )
	{
		Coffee cf = new Coffee("regular Coffee", SIZE.size.SMALL, false,false);
		Alcohol al = new Alcohol ("Mohito", SIZE.size.SMALL, false);
		Smoothie sm1 = new Smoothie("Detox", SIZE.size.MEDIUM,1,false);
		Smoothie sm2 = new Smoothie("Detox", SIZE.size.LARGE,1,false);
		
		r1.addNewBeverage("regular Coffee", SIZE.size.SMALL, false,false);
		r1.addNewBeverage("Mohito", SIZE.size.SMALL); 
		r1.addNewBeverage("Detox", SIZE.size.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(0).equals(cf) );
		assertTrue(r1.getBeverage(1).equals(al) );
		assertTrue(r1.getBeverage(2).equals(sm1) );
		assertFalse(r1.getBeverage(2).equals(sm2) );
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException   {
		
		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("regular Coffee", SIZE.size.SMALL, false,false);
	 	assertTrue(r1.getBeverage(0).getBeverageType().equals(TYPE.type.COFFEE));
		r1.addNewBeverage("Mohito", SIZE.size.SMALL); 
		assertTrue(r1.getBeverage(1).getBeverageType().equals(TYPE.type.ALCOHOL));
		r1.addNewBeverage("Detox", SIZE.size.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(2).getBeverageType().equals(TYPE.type.SMOOTHIE));
		assertTrue(r1.getTotalItems() == 3);
		
		r2.addNewBeverage("Detox", SIZE.size.MEDIUM,4,true); 
		assertTrue(r2.getBeverage(0).getBeverageType().equals(TYPE.type.SMOOTHIE));
		r2.addNewBeverage("Mohito", SIZE.size.SMALL); 
		assertTrue(r2.getBeverage(1).getBeverageType().equals(TYPE.type.ALCOHOL));
		r2.addNewBeverage("regular Coffee", SIZE.size.MEDIUM, true,false);
		assertTrue(r2.getBeverage(2).getBeverageType().equals(TYPE.type.COFFEE));
		assertTrue(r2.getTotalItems() == 3);
		 
	}
	 
	 
	@Test
	public void testCalcOrderTotal()   {
		r1.addNewBeverage("regular Coffee", SIZE.size.SMALL, false,false);
	 	r1.addNewBeverage("Mohito", SIZE.size.SMALL); 
		r1.addNewBeverage("Detox", SIZE.size.MEDIUM,1,false); 
	 
		assertEquals(7.5,r1.calcOrderTotal(),.01);
		
		r2.addNewBeverage("regular Coffee", SIZE.size.MEDIUM, true,false);
	 	r2.addNewBeverage("Mohito", SIZE.size.SMALL); 
		r2.addNewBeverage("Detox", SIZE.size.MEDIUM,4,true); 
		
		assertEquals(12.6,r2.calcOrderTotal(),.01);
		 
	}
	
	 
 

}