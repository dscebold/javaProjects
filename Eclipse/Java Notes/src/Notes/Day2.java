package Notes;

import java.util.Scanner; // importing gets the blueprints of an object 


public class Day2 {

	public static void main(String[] args) {
		
		//variables
		String word = "words and stuff";
		//DataType variable name = value
		int num = 5;
		char equals = '=';
		
		System.out.println(word);
		
		System.out.println(num + num);
		
		System.out.println(num + " " + "+" + " " +num + " " + equals + " " + (num + num));
		//5 + 5 = 10
		
		//Math operators
			/*
			 * 
			 * 	+ add
			 * 	- subtract
			 * 	/ divide
			 * 	* multiply
			 * 	% modulus 	(remainder) 5 % 6 == 5 4 % 2 == 0
			 * 	Math.sqrt()
			 */
		// + can also be used to cocatinate variables together
		
		//object instance
		Scanner scan = new Scanner(System.in);
		//ObjectName variableNAme = new ObjectName(parameters); 
		//NotReal someVariable = new NotReal();
		
		System.out.println("What is your name?");
		
		String name = scan.nextLine();	// this saves the next thing typed in the console
		
		System.out.println("Hello " + name + ".");
		
		//Boolean operators 
		/* 
		 * primitives 
		 * 		<	5 < 6 true
		 * 		>
		 * 		<=
		 * 		>=
		 * 		==		Check for equality of primitives
		 * 		!= 		Checks for inequality 	5!=5 false 	'a' != 'b' true
		 * objects
		 * 		"name".equals("word") 	checks for equality of objects
		 */
		
		System.out.println("What is your favorite food?");
		String food = scan.nextLine();
		//Conditionals
		if(food.equals("steak")) {
			System.out.println("Then you must like Gov Ricketts proclomation yesterday");
		}
		else if(food.equals("pizza")) {
			System.out.println("Anyone else miss 1000 Degrees?");
			
		}
		else {
			System.out.println("I also like " + food + ".");
		}
		
		//ways to protect from case problems
		System.out.println("Some question?");
		String answer = scan.nextLine().toLowerCase(); //collecting a lowercase version of what was typed
		String wordTwo = "Word";
		wordTwo = wordTwo.toLowerCase(); //reassigning the variable to a lowercase version of itself
		System.out.println(answer);
				
		String exampleTwo = "bad CAPITALS and Stuff";
		if( exampleTwo.equalsIgnoreCase("bad capitals and stuff")) {	System.out.println("Is true");
		}
		
		else {
			System.out.println("is false"); 
			}
		
		scan.close();
		

	}

}
