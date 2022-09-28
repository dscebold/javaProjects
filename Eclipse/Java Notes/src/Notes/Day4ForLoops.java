package Notes;

import java.util.Scanner;

public class Day4ForLoops {

	public static void main(String[] args) {
		//for loops are the java workhorse
			//use this loop when you know how many times something should run
			//Also use this loop to go through a collection of stuff
		//for(initialized variable ; termination point; increment ) { 	code }
		for(int i = 0; i <= 5; i++) {
			System.out.println(i);
		}
		
		for(;;) {
			System.out.println("Young");
			break;
		}
		
		
		for(int i = 5 ; i > 0 ; i--) {
			System.out.println(i);
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Type a Word");
		String word = scan.nextLine();
		
		for(int i = 0 ; i < word.length(); i++ ) {
			System.out.println(word.substring(i, word.length()));
		}
		
		//if(5==5) {
			//String x = "x";
		//}
		// System.out.println(x);
		
		String output = "";
		for(int i = 0 ; i < word.length(); i++ ) {
			if(word.charAt(i) == 'a' || word.charAt(i) == 'e') {
				output += "*";
			}
			else { 
				output += word.charAt(i);
				
			}
		}
		System.out.println(output);
		
		
		/* 
		 * || or boolean || boolean if either side is true it will be true
		 * && and boolean && boolean if either side is false it will be false
		 * (true && false) || true && false || (true || false) && false
		 * 
		 * cannot do this 		0 < x < 10  	DO THIS 0 < x && x < 0
		 */
		
		String backwords = "";
		for(int i = word.length() - 1 ; i > -1 ; i--) {
			backwords += word.charAt(i);
			
		}
		System.out.println(backwords);
		
		
		
		scan.close();
		
	}

}
