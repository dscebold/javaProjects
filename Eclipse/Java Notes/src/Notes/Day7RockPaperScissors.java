package Notes;

import java.util.Random;
import java.util.Scanner;

public class Day7RockPaperScissors {
	
	public static String computerTurn(int num) {
		if(num == 0) {
			return "rock";
		}
		else if( num == 1) {
			return "paper";
			
		}
		
		return "scissors";
	}
	
	public static int determineWinner(String you, String comp) {
		if(you.equalsIgnoreCase(comp) ) {
			System.out.println("You chose " + you + " and the computer chose " + comp + ".");
				System.out.println("You tied");
				return 0;
			}
		if(you.equalsIgnoreCase("rock")) {
			if(comp.equalsIgnoreCase("paper")) {
				System.out.println("Paper covers rock. You lose.");
				return 1;
			}
			else {
				System.out.println("Rock crushes scissors. You win");
				return 2;
			}
		}
		else if(you.equalsIgnoreCase("paper")) {
			if(comp.equalsIgnoreCase("rock")) {
				System.out.println("Paper covers rock. You win.");
				return 2;
			}
			else {
				System.out.println("Scissors cut paper. You lose.");
				return 1;
			}
		}
		else if(you.equalsIgnoreCase("scissors")) {
			if(comp.equalsIgnoreCase("rock")) {
				System.out.println("Rock crushes scissors. You lose.");
				return 1;
			}
			else {
				System.out.println("Scissors cuts paper. You win.");
				return 2;
			}
		}
		System.out.println("Please type \"rock\" \"paper\" \"scissors\"");
		System.out.println("You " + you + "\nComp: " + comp);
		return 0;
	}
		
	public static void main(String[] args) {
		
		System.out.println("Rock... Paper... Scissors");
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		int computerWins= 0;
		int yourWins = 0;
		
		while(computerWins < 3 && yourWins < 3) {
			String compChoice = computerTurn(rand.nextInt(3));
			String you = scan.nextLine();
			int result = determineWinner(you, compChoice);
			if(result == 1 ) {
				computerWins++;
			}
			else if( result == 2) {
				yourWins++;
			}
			System.out.println("You: " + yourWins + "\nComputer: " + computerWins);
		}
		
		scan.close();
	}

}
