import java.util.Random;



public class DayThreeReview {

	public static void main(String[] args) {
		
	Random rand = new Random(); 
	
	
	int count = 0; 
	for(int i = 0; i < 100; i++) {
		int randNum = rand.nextInt(100) + 1;
		if(randNum >= 20 && randNum <= 30) { // 20 <= randNum <= 30 cannot do that
			count++;
		}
	}
	System.out.println("Num was between 20-30 was found  " + count + " times.");
	
	
	count = 0; 
	for(int i = 0; i < 100; i++) {
		int randNum = (int)(Math.random() *100) + 1;
		if(randNum >= 20 && randNum <= 30) { // 20 <= randNum <= 30 cannot do that
			count++;
		}
	}
	System.out.println("Num was between 20-30 was found  " + count + " times.");
	
	//String Methods
	java.util.Scanner fred = new java.util.Scanner(System.in); 
	
	String word = fred.nextLine(); 
	
	System.out.println("Type a word for fred");
	System.out.println("First Letter: " + word.charAt(0));
	System.out.println("Length: " + word.length());
	System.out.println("Last Letter: " + word.charAt(word.length() - 1));
	System.out.println("Skipping the first letter: " + word.substring(1));
	System.out.println("First two letters: " + word.substring(0, 2));
	System.out.println("Uppercase: " + word.toUpperCase());
	System.out.println("Lowercase: " + word.toLowerCase());
	System.out.println(word.replace("a", "AAAAA"));
	
	if(word.equalsIgnoreCase("YeS")) {
		System.out.println("You typed yes.");
	}
	if(word.contains("yes")) {
		System.out.println("Contained lowercase yes.");
	}
	if(word.toLowerCase().contains("yes")) {
		System.out.println("Yes was found and I don't know the case.");
	}
	
	if(word.indexOf("thing") > -1) {
		System.out.println("found it.");
	}
	System.out.println(word.indexOf("thing"));
	
	
	DayThreeFunctions.printHi(); //this is a static call to a public function in the package
	
	
	fred.close();
	}

	

}
