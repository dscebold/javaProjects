package GridWorld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

public class BugRunner {
	
	public static void main(String[] args) {
		
		ActorWorld world = new ActorWorld(); // the place that actors live
		Bug bob = new Bug(); // a type of actor
		
		world.add(bob); // this puts the actor in the world
		world.add(new Rock());
		
		world.show(); // displays the world
	}

}
