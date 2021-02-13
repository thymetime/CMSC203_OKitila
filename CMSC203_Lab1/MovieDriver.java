import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String title, rating, answer;
		int numtickets;
		boolean cont = true;
		
		while (cont) {
			Movie mov1 = new Movie();
			
			System.out.print("Enter the tile of the movie: ");
			title = keyboard.nextLine();
			mov1.setTitle(title);
			
			System.out.print("Enter the rating of the movie: ");
			rating = keyboard.nextLine();
			mov1.setRating(rating);
			
			System.out.print("Enter the number of tickets sold at the Rockville Theater: ");
			numtickets = keyboard.nextInt();
			mov1.setSoldTickets(numtickets);
			
			System.out.println();
			System.out.println(mov1.toString());
			
			System.out.print("Do you want to continue? (y/n): ");
			keyboard.nextLine();
			answer = keyboard.nextLine();
			
			//Input validation for yes/no response
			while (!("N".equalsIgnoreCase(answer)) && !("NO".equalsIgnoreCase(answer)) && 
				   !("Y".equalsIgnoreCase(answer)) && !("YES".equalsIgnoreCase(answer))) {
				
				System.out.print("Please enter yes or no: ");
				answer = keyboard.nextLine();
				
			}
			
			//Break out of loop if answer is no
			if ("NO".equalsIgnoreCase(answer) || "n".equalsIgnoreCase(answer)) {
				cont = false;
				break;
			}
			
			System.out.println();
		}
		
		System.out.println("Goodbye");
		
		keyboard.close();
	}
	
	

}
