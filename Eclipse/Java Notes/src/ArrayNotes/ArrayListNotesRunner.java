package ArrayNotes;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListNotesRunner {

	public static void main(String[] args) {
		//Declare the arraylist
		ArrayList<String> names = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		names.add("Jane"); // puts a new object at index 0
		names.add("John"); // puts a new object at the index 1
		System.out.println(names);
		
		while(true) {
			System.out.println("Add a name? ");
			String name = scan.nextLine();
			if(name.equalsIgnoreCase("end")) {
				break;
			}
			names.add(name);
		}
		System.out.println(names);
		
		names.remove("Jane");
		System.out.println(names.remove("Bob"));
		while(true) {
			System.out.println("Remove a name? ");
			String name = scan.nextLine();
			if(name.equalsIgnoreCase("end")) {
				break;
			}
			names.remove(name);
		}
		System.out.println(names);
		
		//ArrayList.size() method array.length field 	String.length() method
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i)); //ArrayList.get(index) returns the item at that index
		}
		names.clear(); //deletes all items in the ArrayList
		System.out.println(names);
		
		//ArrayLists must contains Objects
		
		//Primitive wrapper classes
		
		/*
		 * byte - Byte
		 * short- Short
		 * int - Integer
		 * long - Long
		 * 
		 * float - Float
		 * double - Double
		 * boolean - Boolean
		 * 
		 * char - Character
		 */
		Integer i = 7;
		System.out.println(i);
		ArrayList<Integer> nums = new ArrayList<>();
		System.out.println(nums);
		
		scan.close();
	}
}
