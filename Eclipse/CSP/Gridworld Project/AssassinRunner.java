package GridWorldB;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;

public class AssassinRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.add(new AssassinCritter());
		world.show();
		for(int i = 0; i < 100; i++) {
			world.add(new Bug());
		}

	}

}
