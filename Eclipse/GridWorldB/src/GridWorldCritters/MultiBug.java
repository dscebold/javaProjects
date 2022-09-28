package GridWorldCritters;

import java.awt.Color;
import java.util.Random;
import info.gridworld.grid.Location;

import info.gridworld.actor.Bug;

public class MultiBug extends Bug {

	protected Random rand;

	public MultiBug() {
		rand = new Random();
		setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
	}

	@Override
	public void act() {
		turn();
		if (rand.nextBoolean()) {
			Location next = getLocation().getAdjacentLocation(getDirection());
			if (getGrid().isValid(next) && getGrid().get(next) == null) {
				// a real location // there is not an actor already there
				new MultiBug().putSelfInGrid(getGrid(), next);
			}
		}
	}
}
