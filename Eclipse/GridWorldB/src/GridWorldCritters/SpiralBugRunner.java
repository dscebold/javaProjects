package GridWorldCritters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class SpiralBugRunner {
	
	public static void main(String[] args) {
	
	ActorWorld world = new ActorWorld(new BoundedGrid(20,20));
	Location loc = new Location(10, 10);
	world.add(loc, new ZBug(5));
	world.show();
		
	}

}
