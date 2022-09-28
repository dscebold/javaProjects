import java.util.HashMap;

public class Tester {

	public static void main(String[] args) {
//		String[] words = {"Phablet", "Flibbertigibbet", "Bupkis", "Doozy"};
//		
//		letterFrequency(words); 
		
//		System.out.println(recur(27));
//		System.out.println(mult(5,4));
//		System.out.println(add(5,4));
		
	}
	
	public static int recur(int n) {
		if(n <= 10) {
			return n * 2;
		}
		else {
			return recur(recur(n/3)); 
		}
	}
	
	
	
	public static String[] letterFrequency(String[] words) {
		String current = "";
		int count = 0;
		String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		HashMap<String, Integer> lets = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase();
		}
		for (String letter : letters) {
			count = 0;
			for (String word : words) {
				for (int i = 0; i < word.length(); i++) {
					current = "" + word.charAt(i);
					if (current.equals(letter)) {
						count++;
					}
				}
			}
			lets.put(letter, count);
		}
		String[] frequency = new String[26];
		int most = 0;
		String hold = "";
		for (int i = 0; i < 26; i++) {
			hold = "";
			most = -1; 
			for (String letter : letters) {
				if (lets.get(letter) > most) {
					most = lets.get(letter);
					hold = letter; 
				}
			}
			frequency[i] = hold; 
			lets.put(hold, -1);
		}
		
		return frequency; 
		
		
		
	}
	
	
	
	public static String mult(int m, int n) {
		String temp = ""; 
		for(int i = 0; i < m*n; i++) {
			temp += "A"; 
		}
		return temp; 
	}
	
	public static String add(int m, int n) {
		String temp = ""; 
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j < n; j++) {
				temp += "B"; 
			}
			
		}
		return temp;
	}
	
	
	 

}
