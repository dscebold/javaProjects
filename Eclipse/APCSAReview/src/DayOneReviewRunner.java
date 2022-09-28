import java.util.Scanner;

public class DayOneReviewRunner {

	public static void main(String[] args) {
		
		
		//This is a one line comment
		
		/*
		 * This is a
		 * multi line comment
		 */
		
		// ctrl + / on highlighted text toggles one line comments
//		kdjvhkjsdvh
//		lskjdhvkjhv
//		aldvajvdh
//		sdvkjsdvh
		
		//syso + ctrl + space + enter
		System.out.println();
		
		System.out.println("5 + 5 = " + (5 + 5));
		
		
		String check = "\\"; 
		System.out.println(check);
		
		
		// + can be used to concat
		
		//math operators 
			/*
			 * +
			 * -
			 * /
			 * *
			 * % 5 % 6 == 5 	7 % 6 == 1
			 */
		//boolean 
		/*
		 *  == checks for primitive equality
		 *  != checks for primitive inequality
		 *  
		 *  !(boolean)  reverses the boolean value
		 *  
		 *  Object.equals(Object)  checks for object equality
		 *  
		 *  String.equalsIgnoreCase(String)  checks for String equality ignoring character case
		 *  StringOne.contains checks if StringTwo is a substring of StringOne
		 *  	"bfvhahkbhksbhkbahkwvyes".contains("yes") == true; 
		 */
		
		
		//Data Types
		/*
		 * primitives (Basic units of data) use as little storage as possible
		 * Whole Numbers
		 * byte - 	-127 -> + 127 		8 bits
		 * short - 	-/+ ~32,000 		16 bits
		 * int - 	-/+ ~2.8 billion	32 bits 	(Default whole number) 
		 * long - 	-/+ big number 		64 bits
		 * Dec
		 * float -  32 bit
		 * double - 64 bit 
		 * 
		 * boolean - true or false
		 * char - a single character and you must use 'a' single quotes
		 * 
		 * Objects - class objects are complicated data types 
		 * 			 made up of primitive data and 
		 * 			 attributes 	constructor(s) 		methods 
		 */
		
		
		//Variables
		
		String bob = "name"; 
		//objects are caps for the first letter
		//variables are lowercase
		//multiWords are camel cased 	thisIsAnExampleOfCamelCase 	snake case for python snake_case
		
	//primitive variable 
	//Datatype variable = value;
	int five = 5;
	double pointSomething = 0.0; 
	boolean bool = true; 
	
	//Object Variable
	//Object variable = new Object(Param); 
	Scanner scan = new Scanner(System.in); 
	
	
	System.out.println("type a name...");
	String aName = scan.nextLine();
	
	System.out.println("Hello " + aName + ".");
	
	System.out.println("Type another example");
	String somethingElse = scan.nextLine(); 
	System.out.println("You typed " + somethingElse + ".");
	}//main method

}
