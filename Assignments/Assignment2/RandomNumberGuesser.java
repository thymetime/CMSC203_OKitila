package assignment2;
import java.util.Scanner;

/**
 * Class: CMSC203 
	Instructor:
	Description: (Give a brief description for each Class)
	Due: 2/23/2021
	Platform/compiler: Eclipse
	I pledge that I have completed the programming assignment independently.
   		I have not copied the code from a student or any source.
   		I have not given my code to any student.
   		Print your Name here: Olyad Kitila

 */

public class RandomNumberGuesser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		String playAgain = "";
		boolean playing = true;
		
		/**
		 * Initialize 'playing' to true for first loop
		 * Asks if user wants to play another game
		 */
		while (playing)
		{
			int randNum = RNG.rand(), nextGuess = -1, lowGuess = 0, highGuess = 100;
			RNG.resetCount();
			
			/**
			 *  loop uses RNG count to continue prompting user until 7 guesses
			 */
			while (RNG.getCount() <= 7) 
			{
				
				if (RNG.getCount() == 0)
					System.out.println("Enter your first guess:");
				else
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess + ":");

				nextGuess = keyboard.nextInt();
				
				while (!RNG.inputValidation(nextGuess, lowGuess, highGuess)) 
				{
					System.out.println("Enter your guess");
					nextGuess = keyboard.nextInt();
				}
				
				RNG num = new RNG();
				System.out.println("Number of guesses is " + RNG.getCount());
				
				/**
				 * 
				 */
				if (nextGuess < randNum) 
				{
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				} 
				else if (nextGuess > randNum) 
				{
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				}
				else if (nextGuess == randNum)
				{	
					System.out.println("Congratulations, you guessed correctly!");
					break;
				}
				else
					System.out.println("You couldn't get the number in 7 tries. It was " + randNum);
				
			}
			
			
			System.out.println("Try again? (yes or no)");
			playAgain = keyboard.nextLine(); // actual user string
			
			/**
			 * input validation for yes/no string
			 * only accepts case ignored "yes" or "no"
			 */
			while (!("NO".equalsIgnoreCase(playAgain)) && !("YES".equalsIgnoreCase(playAgain)))
			{
				System.out.println("Please choose yes or no");
				playAgain = keyboard.nextLine();
			}
			
			/**
			 * if user enters no, boolean becomes false to end the outer while loop
			 * uses break to exit inner while loop
			 */
			if ("NO".equalsIgnoreCase(playAgain)) 
			{
				playing = false;
				System.out.println("Thanks for playing...");
				break;
			}
			
			System.out.println();
			System.out.println();
		}
		
		keyboard.close();

	
	}
}
