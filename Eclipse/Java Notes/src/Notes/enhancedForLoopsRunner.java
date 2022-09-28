package Notes;

import java.util.ArrayList;

public class enhancedForLoopsRunner {

	public static void main(String[] args) {
		//Enhanced For Loops are made for going through collection
			//You cannot change the size of the collection in an enhanced for loop
			//for(Object variable: collection) {}
		String[] names = {"Guy", "hue", "Peter", "Sue", "Jane", "Cindy"};
		
		for(String name : names) {
			System.out.println("Hello " + name + "!");
		}
		
		for(int i = 0 ; i < names.length; i++) {
			System.out.println("Hello " + names[i] + "!");
		}
		
		ArrayList<String> words = new ArrayList<String>();
		String word = "Word #";
		for(int i = 0 ; i < 10; i++) {
			words.add(word + (i+1));
		}
		
		for(String thing : words) {
			if(thing.contains("6")) {
				// word.removes(thing); this throws a concert modification error
					//you also con't add inside of an enhanced for loops
			}
		}
		
		
		System.out.println(words);
	}
}
