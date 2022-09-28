package GridworldC;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class BeamCritter extends Bug {

	public BeamCritter() {
		super();
	}

	@Override
	public void act() {
		if (canMove())
			move();
		else {
			removeSelfFromGrid();
		}
	}

	public ArrayList<Actor> explosion() {
		return getGrid().getNeighbors(getLocation());
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

}
