package GridWorldCritters;

import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class DashyBug extends Bug {

	protected Random rand;

	public DashyBug() {
		rand = new Random();
	}

	@Override
	public void act() {
		for (int i = 0; i < rand.nextInt(26) + 25; i++) {
			if (canMove()) {
				move();
				if (rand.nextInt(3) == 1) {
					turn();
				}
			}

			else {
				turn();
			}
		}
		Location next = getLocation().getAdjacentLocation(getDirection());
		if(rand.nextInt(5) == 1) {
			new FlashyBug(0).putSelfInGrid(getGrid(), next);

		}
		else {
			new MultiBug().putSelfInGrid(getGrid(), next);
		}
	}

}
