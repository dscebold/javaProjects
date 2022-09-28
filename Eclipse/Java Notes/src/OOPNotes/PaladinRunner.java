package OOPNotes;

public class PaladinRunner {

	public static void main(String[] args) {
		Paladin me = new Paladin(false);
		Paladin bot = new Paladin(true);
		
		System.out.println(me.toString());
		System.out.println(bot.toString());
		
		while(me.isAlive() && bot.isAlive()) {
			me.turn(bot);
			if(bot.isAlive()) {
				bot.turn(me);
			}
		}
		

	}

}
