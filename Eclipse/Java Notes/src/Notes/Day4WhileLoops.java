package Notes;

import java.util.Scanner;

public class Day4WhileLoops {

	public static void main(String[] args) {
		// while
			/*
			 * We use while loops when we do not know how many time something would happen
			 * while(boolean)
			 */
		
		while(true) {
			System.out.println("Looping");
			break; // this keyword will break the innermost loop
			
		}
		
		//while loop with counter
		
		int count = 0;			//initialized variable
		while(count < 5) {		//termination point
			count++;			 //increment		 // same as 	count = count + 1
			System.out.println(count);
		}
		
		
		Scanner scan = new Scanner(System.in);

		
		System.out.println("What is the password");
		
		while(!(scan.nextLine().equals("1234"))) {
			System.out.println("Not the correct password. \n Pleae try again.");
		}
		
		/*
		 * 	\n is newline
		 * 	\t is tab
		 * 	\\ is how you print one \
		 * 	\" is how your print a " without terminating a string
		 */
		
		System.out.println("She said, \"Yes!\"");
		
	
		while(true ) {
			System.out.println("What is the most amazing color?");
			String color = scan.nextLine().toLowerCase();
			if(color.equals("rainbow")) {
				System.out.println("We are done talking now... I asked for one..");
				break;
				
			}
			else { 
				System.out.println(color + " is an interesting color. I never really thought about it...");
				
			}
		}
	
		
		
		scan.close();
	
	
	}

}
