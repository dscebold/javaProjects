package GridWorldB;

import java.awt.Color;

import GridWorldCritters.BoxBug;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class RingCritter extends BoxBug {

	public RingCritter(int size) {
		super(size);
		setColor(Color.GRAY);
	}

	@Override
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (gr.isValid(next))
			moveTo(next);
		else
			removeSelfFromGrid();
	}

	@Override
	public void act() {
		if (steps < sideLength && canMove()) {
			move();
			steps++;
		} else if ((steps < sideLength) && (canMove() == false)) {
			for(int i = 0; i < 8 ; i++) {
				turn();
			}
			
		}
		else {
			turn();
			turn();
			steps = 0;
		}
	}

}
