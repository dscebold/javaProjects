package OOPNotes;

public class DietyRunner {

	public static void main(String[] args) {
		
		
		Diety fred = new Diety();
		Diety b = new Diety();
		
		
		
		
		System.out.println(fred.toString());
		System.out.println(b.toString());
		
		while(fred.isBelief() && b.isBelief()) {
			fred.attack(b);
			if(b.isBelief()) {
				b.attack(fred);
			}
			System.out.println(fred.toString());
			System.out.println(b.toString() + "\n");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
