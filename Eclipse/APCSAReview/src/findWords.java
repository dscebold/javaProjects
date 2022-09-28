import java.util.Scanner;

public class findWords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		String text = scan.nextLine();
		
		String find = scan.nextLine(); 
		
		int count = 0; 
		
		int start = 0; 
		
		for(int i = 0; i < text.length(); i++) {
			text = text.substring(start); 
			if(text.indexOf(find) > -1) {
				count++;
				start = text.indexOf(find) + 1; 
			}
		}

	}

}
