package GridWorldCritters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.*;

public class VampireRunner {

	public static void main(String[] args) {
		
		ActorWorld world = new ActorWorld();
		for(int i = 0; i < 7; i++) {
			world.add(new Critter());
			world.add(new Bug());
			world.add(new Rock());
		}
		world.add(new VampireCritter());
		world.add(new VampireCritter());

		world.show();

	}

}
