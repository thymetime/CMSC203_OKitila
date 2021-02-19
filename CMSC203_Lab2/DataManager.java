package Lab2;

import java.util.Random;


/**
 * The DataManager class should never depend on the GUI, but rather the reverse. 
 * So the DataManager methods should not use the GUI directly.  If you want data
 * to get from the user to the manager, have the GUI get the data, and call the manager 
 * with the data that the GUI got from a text field or other data structure.
 * @author ralexander
 *
 */
public class DataManager {
    private String[] greetings = 
    
    { 		
    		"English: Hello",
    		"Afaan Oromo: Uffadhu!",
    		"Español: ¡Hola!",
    		"Français: Bonjou!",
    		"Korean: Annyeonghaseyo!",
    		"Hindi: Namaste!",
    		"Russian: Privyet",
    		"Arabic: Marhaba"
    };
    
    private Random rand = new Random();
	
	DataManager() {	}

	/** 
	 * This method illustrates how the GUI can interact with the manager
	 */
	public String getHello() {
		return "Hello World";
	}

	public String getHowdy() {
		return "Howdy y'all";
	}

	public String getChinese() {
		return "Ni hau";
	}
	
	public String getGreeting() {
	    return greetings[rand.nextInt(greetings.length)];
	}


}