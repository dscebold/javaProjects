package OOPNotes;

public class PantheonRunner {

	public static void main(String[] args) {
		Pantheon theFirst = new Pantheon();
		System.out.println(theFirst.toString());
		Pantheon theSecond = new Pantheon();
		System.out.println(theSecond.toString());
		
		while(theFirst.isBelief() && theSecond.isBelief()) {
			theFirst.attack(theSecond);
			if(theSecond.isBelief()) {
				theSecond.attack(theFirst);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
		System.out.println(theFirst.toString());
		System.out.println(theSecond.toString());

	}

}
