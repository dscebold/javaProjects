import java.util.Scanner;

public class Poster {
	
	//attributes 
		//the stuff an object is made of
		//typically set to private
			//public if it is static and it must be declared/ initialized
			//protected if it is inherited
		private Scanner scan;
		private String message;
		private int value;
		private boolean isCool; 
		private String[] words;
		
		
	//Constructor
		//runs when you make an instance of an object
		//used to assign values to attributes
		//access modifier should be public
		//always named the same as the class file name
		public Poster() {
			scan = new Scanner(System.in);
			message = setMessage();
			words = message.split(" "); // seperates he message into "words" based on spaces
			setValue();
			setisCool();
			
		}
		
	private void setisCool() {
		this.isCool = this.value > 0 || this.message.contains("Betty White");		
	}

	//Methods 
		//These are functions that belong to a class
		//they are the "stuff a class can do"
		// normal methods found in most classes include getters and setters
			//used to get private attribute values
			//used to set private attribute values
		//all classes inherit some methods from Java Object
			//.equals()     .toString()   ....
	
	
		@Override
		public String toString() {
			String cool = "cool"; 
			if(this.isCool == false) {
				cool = "not cool";
			}
			return "The Message Is: \n\t" + this.message + "\n\tThe Message is " + cool.toUpperCase() + "!"; 
		}
 		
		
		public String setMessage() {
			System.out.println("What will this poster say?");
			return scan.nextLine(); 
		}
		
		
		public void setValue() {
			this.value = 0; 
			this.value += getGoodValue();
			this.value -= getBadValue(); 
			if(words.length> 10 || words[0].length() > 30) {
				this.value -= words.length; 
				if(words[0].length() > 30) {
					this.value -= 1000; 
				}
			}
		}

		private int getBadValue() {
			int total = 0; 
			String[] badWords = {"political", "covid", "rape", "amber", "heard", "bonding", "moist", "happy", "sad", "ing", "adult", "est", " ist", ".", "acid", "vomot", "oils", "collegeboard", "cide", "genocide", "shepard", "ism", "astrology", "ology", "short", "small", "error", "rick", "karen", "brad"};
			for(String word: this.words) {
				for(String great: badWords) {
					if(word.toLowerCase().contains(great)) {
						total += 5;
					}
				}
			}
			
			return total;
		}

		private int getGoodValue() {
			int total = 0; 
			String[] greatWords = {"bee", "meme", "jazz", "movie", "spider-man", "fish", " awesome", "fuck", "shrek", "gems", "duck", "dwayne", "rock", "the", "amazon", "rare", "science", "research", "bill", "drone", "pigeon", "namo", "technology", "young", "berzina", "ryan", "reynolds", "drug"};
			for(String word: this.words) {
				for(String great: greatWords) {
					if(word.toLowerCase().contains(great)) {
						total += 5;
					}
				}
			}
			
			return total;
		}
		
		public boolean isCool() {
			return this.isCool;
		}
	
	
}
