package GridworldC;

import GridWorldCritters.Heart;
import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Bullet extends Bug {

	public Bullet() {
		super();
	}

	@Override
	public void act() {
		for (int i = 0; i < 5; i++) {
			if (canMove())
				move();
			else if (getGrid() != null) {
				removeSelfFromGrid();
			}
		}
	}

	@Override
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Actor neighbor = gr.get(next);
		if(neighbor == null || (neighbor instanceof Heart) || (neighbor instanceof Bullet)) {
			moveTo(next);
		}
		else if(neighbor instanceof Rock) {
			removeSelfFromGrid();
		}
		else {
			neighbor.removeSelfFromGrid();
			removeSelfFromGrid();
		}
		Heart heart = new Heart(6);
		heart.putSelfInGrid(gr, loc);
	}

	@Override
	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		else {
			return true;
		}
	}

}
