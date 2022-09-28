package GridWorldCritters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class BugRunner {

	public static void main(String[] args) {

		ActorWorld world = new ActorWorld(); // the place that actors live
		
		
		for(int i = 0; i< 100; i++) {
			for(int j = 0 ; j < 100; j++) {
				Location loc = new Location(i, j);
				world.add(loc, new Bug());
			} 
		}
		
		world.show();

	}

}
