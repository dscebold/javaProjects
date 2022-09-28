package GridWorldCritters;

import info.gridworld.actor.*;

public class RockWorld extends ActorWorld{
	
	@Override
	public void step() {
		super.step();
		if((int)(Math.random() * 100) == 2) {
			new Rock().putSelfInGrid(getGrid(), getRandomEmptyLocation());
		}
	}

}
