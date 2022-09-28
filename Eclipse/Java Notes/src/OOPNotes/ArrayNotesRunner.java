package OOPNotes;

public class ArrayNotesRunner {

	public static void main(String[] args) {
		
		
		int[] num = new int[5]; //declare an array of 5 ints set to 0
		String[] names;
		names = new String[5];
		
		
		
		//String.length()
		//array.length
		
		for( int i = 0 ; i < num.length ; i++) { // array.lenght 	how many items are in array
			System.out.println(num[i]); // array index gives you the item at that location
			names[i] = "person #" + ( i + 1 );
			System.out.println(names[i]);
			
		}
		
		String[] people = { "Guy" , "Hue", "June", "Jesse" }; //assign variables that you know the
		
		System.out.println(people);
		

	}

}
