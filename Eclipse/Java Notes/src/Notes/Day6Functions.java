package Notes;

import java.util.Scanner;

public class Day6Functions {
	
	//AccessModifier 	static 	returnType		VariableName (ParametersIfAny) { code }
	public static void printHi() {
		System.out.println("Hello");
	}
	
	public static void sayHiTo(String name ) {
		System.out.println("Hello " + name + ".");
	}
	
	public static void printSum(int num, int numTwo) {
		System.out.println(num + " + " + numTwo  + " = " + (num + numTwo));
		
	}
	//Overrides the other printSum (The Params decide which one runs)
	public static void printSum(double num, double numTwo) {
		System.out.println(num + " + " + numTwo  + " = " + (num + numTwo));
		
	}
	
	public static double divideTwo(double one, double two) {
		return one / two ;
				
	}
	
	public static double divideTwo(int one, int two) {
		return one / two ;
				
	}
	
	public static String askQuestion() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What are you thinking about?");
		String question = scan.nextLine();
		scan.close();
		return question;
	}
	
	public static String askThisQuestion(String question) {
		Scanner scan = new Scanner(System.in);
		System.out.println(question);
		String temp = scan.nextLine();
		scan.close();
		return temp;
		
	}

	public static String respondTo(String question) {
		String answer = askThisQuestion(question);
		if(answer.equalsIgnoreCase("red")) {
			return "Are you angry?";
		}
		else if(answer.equalsIgnoreCase("blue")) {
			return "are you sad?";
		}
		return "Oh I see";
		
	}
	
	public static boolean inRange( int num, int low, int high) {
//		if(num > low) {
//			if(num < high) {
//				return true;
//			}
//		}
//		return false;
		return num > low && num < high; 
	}

	public static void main(String[] args) {
		
		
		
		printHi();		// to call a function, type functionName(params);
		printHi();
		printHi();
		sayHiTo("Guy");
		sayHiTo("Person");
		sayHiTo("Friend");
		printSum(5, 17);
		printSum(4, 9);
		printSum(6, 8.567);
		double example = divideTwo(5.0,7.0);
		System.out.println(example);
		System.out.println(divideTwo(5, 7));
		System.out.println("You are thinking about " + askQuestion() + ".");
		System.out.println("Your weekend was " + askThisQuestion("How was your weekend?") + ".");
		System.out.println(respondTo("What color best describes your mood today"));
		
		
	

	}

}
