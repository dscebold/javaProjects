package GridWorldCritters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;

public class UnicornRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid(25, 25));
		world.add(new UnicornCritter());
		world.add(new UnicornCritter());
		world.add(new UnicornCritter());
		
		world.show();
	}

}
