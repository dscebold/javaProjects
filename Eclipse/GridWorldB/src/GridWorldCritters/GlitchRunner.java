package GridWorldCritters;

import info.gridworld.actor.*;

public class GlitchRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		for(int i = 0; i < 10 ; i++) {
			world.add(new Critter());
			world.add(new Rock());
		}
		world.add(new GlitchCritter());
		world.show();

	}

}
