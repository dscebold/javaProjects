package GridWorldCritters;

import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class VampireCritter extends Critter {

	// Attribute
	private ArrayList<Actor> eaten;

	// Constructor
	public VampireCritter() {
		eaten = new ArrayList<>();
		setColor(new Color(255, 0, 0));
	}

	// Methods

	@Override
	public void act() {
		super.act();
		darken();
		if (getColor().equals(new Color(0, 0, 0))) {
			placeEaten();
			removeSelfFromGrid();
		}
	}

	private void placeEaten() {
		while (this.eaten.size() > 0 && super.getMoveLocations().size() > 0) {
			eaten.get(0).setColor(Color.RED);
			eaten.get(0).putSelfInGrid(getGrid(), selectMoveLocation(super.getMoveLocations()));
			eaten.remove(0);
		}

	}

	@Override
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (!(a instanceof Rock) && !(a instanceof Flower)) {
				this.eaten.add(a);
				a.removeSelfFromGrid();
				setColor(new Color(255, 0, 0));
			}
		}
	}
	
	@Override
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(getLocation());
		for(int i = 0; i < locs.size(); i++) {
			if(nearFlower(locs.get(i))) {
				locs.remove(i);
				i--;
			}
		}
		return locs;
	}

	private boolean nearFlower(Location location) {
		ArrayList<Location> nearLocs = getGrid().getValidAdjacentLocations(location);
		for(Location loc : nearLocs) {
			if(getGrid().get(loc) instanceof Flower) {
				return true;
			}
		}
		return false;
	}

	private void darken() {
		int curRed = this.getColor().getRed();
		curRed -= 25;
		if (curRed < 0) {
			curRed = 0;
		}
		this.setColor(new Color(curRed, 0, 0));

	}

}
