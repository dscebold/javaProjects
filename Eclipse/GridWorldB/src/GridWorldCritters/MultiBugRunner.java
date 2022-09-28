package GridWorldCritters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class MultiBugRunner {

	public static void main(String[] args) {
		
		ActorWorld world = new ActorWorld(new UnboundedGrid());
		Location loc = new Location(0,0);
		world.add(loc, new DashyBug());
		world.show();

	}

}
