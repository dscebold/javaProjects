package OOPNotes;

public class HumanRunner {

	public static void main(String[] args) {
		
		Human steve = new Human("Steve");
		Human amy = new Human("amy");
		
		for( int i = 0 ; i < 20 ; i++ ) {
			steve.setAge();
			amy.setAge();
		}
		
		
		System.out.println(steve.toString());
		System.out.println(amy.toString());

	}

}
