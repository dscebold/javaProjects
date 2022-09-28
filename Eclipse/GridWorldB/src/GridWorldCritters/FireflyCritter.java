package GridWorldCritters;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class FireflyCritter extends Critter {

	// Attributes
	private Random rand;
	private int state;

	// Constructor
	public FireflyCritter() {
		rand = new Random();
		state = 0;
		setColor(Color.BLACK);
	}

	// Methods

	@Override
	public void act() {
		if (getGrid() == null) { // makes sure this actor is still on the grid before doing anything
			return;
		}
		// find other yellow fireflies
		ArrayList<Actor> otherFlies = getOtherFlies();
		if (otherFlies.isEmpty()) {
			makeMove(selectMoveLocation(getMoveLocations())); // move like a default critter
		} else {
			moveToFlies(otherFlies);
		}
		flash();
	}

	private void moveToFlies(ArrayList<Actor> otherFlies) {
		Actor target = pickaFly(otherFlies);
		int dir = getLocation().getDirectionToward(target.getLocation());
		Location next = getLocation().getAdjacentLocation(dir); // save the loc in that direction
		if (getGrid().isValid(next) && getGrid().get(next) == null) { // real loc and not occupied
			makeMove(next);
		}

	}

	private Actor pickaFly(ArrayList<Actor> otherFlies) {
		Actor nearest = new Actor();
		double dist = 1000000;
		for (Actor a : otherFlies) {
			if (isCloser(a, dist)) {
				nearest = a;
				dist = saveDist(a);
			}
		}
		return nearest;
	}

	private boolean isCloser(Actor a, double dist) {
		return saveDist(a) < dist;
	}

	private double saveDist(Actor a) {
		return Math.sqrt(Math.pow(a.getLocation().getCol() - this.getLocation().getCol(), 2)
				+ Math.pow(a.getLocation().getRow() - this.getLocation().getRow(), 2));
	}

	private ArrayList<Actor> getOtherFlies() {
		ArrayList<Location> allLocs = getGrid().getOccupiedLocations(); // saved all locations with an actor
		ArrayList<Actor> yellowFlies = new ArrayList<Actor>();
		for (Location loc : allLocs) { // looks at every location
			Actor temp = getGrid().get(loc); // saves the current actor
			if (temp instanceof FireflyCritter && temp.getColor().equals(Color.YELLOW) && !(temp.equals(this))) {
				yellowFlies.add(temp);
			}
		}
		return yellowFlies;
	}

	private void flash() {
		if (rand.nextInt(26) < 3 && this.state <= 0) {
			setColor(Color.YELLOW);
			this.state = 2;
		} else {
			this.state--;
			if (this.state <= 0) {
				setColor(Color.BLACK);
			}
		}

	}

}
