package GridWorldCritters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;

public class FireflyRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid<>(15,15));
		for(int i = 0 ; i < 7 ; i++ ) {
			world.add(new FireflyCritter());
		}
		
		world.show();

	}

}
