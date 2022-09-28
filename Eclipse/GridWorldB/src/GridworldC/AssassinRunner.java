package GridworldC;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;

public class AssassinRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid<>(20, 20));
		world.add(new AssassinCritter());
		world.show();
		for(int i = 0; i < 399; i++) {
			world.add(new Bug());
		}

	}

}
