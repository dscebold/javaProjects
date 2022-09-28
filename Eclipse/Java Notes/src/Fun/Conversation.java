package Fun;

import java.util.Scanner;

public class Conversation {

	public static void main(String[] args) {
		System.out.println("Hello, Whats your name?");
		
		Scanner scan = new Scanner(System.in);
		
		String name = scan.nextLine();
		
		System.out.println("Hello " + name +" , how are you");
		
		String status = scan.nextLine();
		
		System.out.println("Thats Great to hear " + name);
		
		System.out.println("Why are you " + status + ".");
		
		System.out.println("Whats your favorite color? " + name);
				
		String color = scan.nextLine();
		
		String vowel = "";
		
		for(int i = 0 ; i < color.length() ; i++ ) {
			if(color.charAt(i) == 'a' || color.charAt(i) == 'e' || color.charAt(i) == 'i' || color.charAt(i) == 'o' || color.charAt(i) == 'u'  ) {
				vowel += "*";
			}
			else {
				vowel += color.charAt(i);
			}
		}
		
		System.out.println(vowel + " is great");
		
		
		scan.close();

	}

}
