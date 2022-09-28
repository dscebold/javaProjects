package GridworldC;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class AssassinCritter extends Critter {

	private Random rand;

	public AssassinCritter() {
		super();
		rand = new Random();
	}

	@Override
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (!(a instanceof Rock) && !(a instanceof Critter))
				if (rand.nextBoolean()) {
					a.removeSelfFromGrid();
				}
		}
	}

	@Override
	public void act() {
		if (getGrid() == null)
			return;
		Location loc = new Location(rand.nextInt(getGrid().getNumCols()), rand.nextInt(getGrid().getNumRows()));
		makeMove(loc);
		ArrayList<Actor> actors = getActors();
		processActors(actors);
	}

	@Override
	public void removeSelfFromGrid() {
		Location loc = new Location(rand.nextInt(getGrid().getNumCols()), rand.nextInt(getGrid().getNumRows()));
		makeMove(loc);
		ArrayList<Actor> targets = getCloseActors();
		for(Actor a : targets) {
			a.removeSelfFromGrid();
		}
		super.removeSelfFromGrid();
	}
	

	private double saveDist(Actor a) {
		return Math.sqrt(
				Math.pow(a.getLocation().getCol() - this.getLocation().getCol(), 2) 
				+ 
				Math.pow(a.getLocation().getRow() - this.getLocation().getRow(), 2)
				);
	}

	private ArrayList<Actor> getCloseActors() {
		ArrayList<Location> allLocs = getGrid().getOccupiedLocations(); // saved all locations with an actor
		ArrayList<Actor> kamikaze = new ArrayList<Actor>();
		for (Location loc : allLocs) { // looks at every location
			Actor temp = getGrid().get(loc); // saves the current actor
			if (!(temp.equals(this)) && (saveDist(temp) <= 2)) {
				kamikaze.add(temp);
			}
		}
		return kamikaze;
	}
}
