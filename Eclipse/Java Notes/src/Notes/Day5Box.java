package Notes;

import java.util.Scanner;

public class Day5Box {

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		System.out.println("How big?");
		int size = scan.nextInt();
		
		Scanner textScanner = new Scanner(System.in);
		System.out.println("What Character");
		String character = textScanner.nextLine();
		
		
		//Full box
		for(int j = 0 ; j < size ; j++ ) {
			String line = "";
			for( int i = 0 ; i < size ; i++) {
				line += character + " ";
			}
		System.out.println(line);
		}
		
		
		
		//hollow box
		
		//top
		String top = character + " ";
		for( int i = 0 ; i < size ; i++ ) {
			top += character + " ";
		}
		System.out.println(top + character);
		//middle
		for( int j = 0 ; j < size ; j++ ) {
			String line = character;
			for( int i = 0 ; i < size ; i++ ) {
				line += "  ";
			}
			System.out.println(line + " " + character);
			
		}
		
		
		//Bottom

		System.out.println(top + character);
		
		
		
		
		
		
		
		
		scan.close();
		textScanner.close();

	}

}
 