import java.util.Scanner;



public class WifiDiagnosis {
	
	static String answer = "";
	static Scanner input = new Scanner(System.in);

	// This method checks the correct step number and prints the corresponding direction
	public static void checkStep(int stepNum) 
	{
		String direction;
		switch (stepNum) {
			case 1: 
				direction = "First step: Reboot your computer\n";
				break;
			case 2:
				direction = "Second step: Reboot your router\n";
				break;
			case 3:
				direction = "Third step: Make sure the cables to your router are plugged firmly and your router is getting power\n";
				break;
			case 4:
				direction = "Fourth step: Move your computer closer to your router\n";
				break;
			default:
				direction = "Contact your ISP\nMake sure your ISP is hooked up to your router\n";

				
		}
		
		System.out.print(direction);
	}
		
	// Asks user if they are able to connect to the Internet
	// Uses input validation and returns a boolean that represents if they're connected
	public static boolean checkNet(boolean connected, boolean firstStep) 
	{
		
		// Uses boolean named firstStep as parameter, which is declared and initialized in main, to determine correct prompt to ask user
		if (firstStep) 
		{
			System.out.print("Now are you able to connect with the internet? (yes or no)\n");
		} 
		else 
		{
			System.out.print("Are you able to connect with the internet? (yes or no)\n");

		}
		
		answer = input.next();
		
		if ("no".equals(answer) || "No".equals(answer) || "NO".equals(answer) || "n".equals(answer) || "N".equals(answer))
		{
			connected = false;
			
		}
		else if ("yes".equals(answer) || "Yes".equals(answer) || "YES".equals(answer) || "y".equals(answer) || "Y".equals(answer))
		{
			connected = true;
		}
		
		return connected;
		//System.out.print(answer + "\n");
	}
	
	// This method returns a string that indicates which step worked for the user. Returns a String for the statement
	public static String printSolution(boolean connection, int stepNum)
	{
		String solution = "";
		switch (stepNum) {
			case 1: 
				solution = "Rebooting your computer ";
				break;
			case 2:
				solution = "Rebooting your router ";
				break;
			case 3:
				solution = "Plugging in the router cables ";
				break;
			case 4:
				solution = "Moving your computer ";
				break;
			default:
				solution = "It seems we were unable to diagnose your issue. Unfortunately nothing ";
		}
		
		
		return solution + "seemed to work.";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		boolean firstStep = true;
		boolean connected = false;
		int stepCounter = 0;
		String stepOutput = "";
		
		System.out.print("If you have a problem with internet connectivity, this Wifi Diagnosis might work.\n");
		do 
		{	
			if (stepCounter > 0)
				firstStep = false;
			stepCounter++;
			checkStep(stepCounter);
			connected = checkNet(connected, firstStep);
			//System.out.println("Answer: " + answer + "\nConnection: " + connected + "\nStep Number: " + stepCounter);
			
		}
		while (connected == false && stepCounter <= 4);
		
		stepOutput = printSolution(connected, stepCounter);
		System.out.println(stepOutput);

		input.close();
	}


}
/* Pseudocode:
 * I will probably need some sort of prompt loop tto ask
 * if their computer is connected. Butt I need to know which 
 * stetp worked for them to display it.
 * 
 * Make a boolean named connected
 * that represents if the intternet is working
 * Make a character varsiable named step 
 * that represents each step
 * Create a function named checkNet
 * 
 * Inside checkNet, create String which asks "Are you able to connect?"
 * if their answer is yes, change boolean to true
 * 
 * The main method will have an event loop that prompts the user, asks the user if they're connected, and tracks their step number
 */
 