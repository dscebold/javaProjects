package GridworldC;

import info.gridworld.actor.*;
import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class BlackHoleRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid<>(200, 200));
		BlackHoleCritter holey = new BlackHoleCritter();
		Location loc = new Location(5, 5);
		world.add(loc, holey);
		for (int i = 0; i < 1000; i++) {
			Bug buggy = new Bug();
			world.add(buggy);
		}

		world.show();

	}

}
