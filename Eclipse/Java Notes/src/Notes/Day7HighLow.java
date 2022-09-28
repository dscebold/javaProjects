package Notes;
import java.util.Random;
import java.util.Scanner;

public class Day7HighLow {

	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int randNum = rand.nextInt(10) +1; //this is a random number between 1-10
						//Random nextInt(num) returns 0 - num non-inclusive of num
		for( int i = 0 ; i < 10 ; i++) {
			randNum = rand.nextInt(10) + 1;
		}
		
		
		System.out.println("Pick a number between 1-10");
		int num = scan.nextInt();
		int guesses = 3;
		while(!(num == randNum) && guesses > 0) {
			if(num > randNum) {
				System.out.println("Too High");
			}
			else if(num < randNum) {
				System.out.println("Too Low");
			}
			guesses--;
			if(guesses !=0) {
				System.out.println("You have " + guesses +" guesses left");
				System.out.println("Guess again");
				num = scan.nextInt();
		}
		if(num == randNum) {
			System.out.println("You win");
			}
		}
		
		
		scan.close();
		
			

		}

}
