package GridworldC;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import GridWorldCritters.FireflyCritter;
import GridWorldCritters.Heart;
import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Zombie extends Critter {

	private Random rand;
	private int life;
	private int count;
	private boolean move;

	public Zombie() {
		super();
		setColor(new Color(150, 75, 0));
		rand = new Random();
		life = 200;
		count = 0;
		move = true;
	}

	@Override
	public void act() {
		if (this.life > 0) {
			if (getGrid() == null)
				return;
			ArrayList<Location> moveLocs = getMoveLocations();
			Location loc = selectMoveLocation(moveLocs);
			if (count == 1 && canMove(loc)) {
				makeMove(loc);
			}
			ArrayList<Actor> actors = getActors();
			processActors(actors);
			life--;
		}
		if (this.life == 0) {
			this.removeSelfFromGrid();
		}
		this.count++;
		if (this.count >= 4) {
			this.count = 0;
		}
	}

	private ArrayList<Actor> getSurvivor() {
		ArrayList<Location> allLocs = getGrid().getOccupiedLocations(); // saved all locations with an actor
		ArrayList<Actor> people = new ArrayList<Actor>();
		for (Location loc : allLocs) { // looks at every location
			Actor temp = getGrid().get(loc); // saves the current actor
			if ((temp instanceof Survivor) && !(temp.equals(this))) {
				people.add(temp);
			}
		}
		return people;
	}

	private double saveDist(Actor a) {
		return Math.sqrt(Math.pow(a.getLocation().getCol() - this.getLocation().getCol(), 2)
				+ Math.pow(a.getLocation().getRow() - this.getLocation().getRow(), 2));
	}

	private double checkDist(Actor a, Location loc) {
		return Math.sqrt(Math.pow(a.getLocation().getCol() - loc.getCol(), 2)
				+ Math.pow(a.getLocation().getRow() - loc.getRow(), 2));
	}

	@Override
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> straights = new ArrayList<>();
		Location north = getLocation().getAdjacentLocation(Location.NORTH);
		Location south = getLocation().getAdjacentLocation(Location.SOUTH);
		Location east = getLocation().getAdjacentLocation(Location.EAST);
		Location west = getLocation().getAdjacentLocation(Location.WEST);
		straights.add(north);
		straights.add(south);
		straights.add(east);
		straights.add(west);
		return straights;
	}

	@Override
	public Location selectMoveLocation(ArrayList<Location> locs) {
		Location move = getLocation();
		if (getSurvivor().size() > 0) {
			Actor survivor = getSurvivor().get(0);
			double dist = saveDist(survivor);
			for (Location closest : locs) {
				if (dist > checkDist(survivor, closest)) {
					dist = checkDist(survivor, closest);
					move = closest;
				}
			}
		}
		return move;
	}

	@Override
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			Location newZombie = a.getLocation();
			if (!(a instanceof Rock) && !(a instanceof Flower) && !(a instanceof Zombie) && !(a instanceof Survivor)
					&& !(a instanceof Bullet) && !(a instanceof Heart) && !(a instanceof ZombieDog)) {
				a.removeSelfFromGrid();
				new Zombie().putSelfInGrid(getGrid(), newZombie);
			} else if (a instanceof Survivor) {
				((Survivor) a).setLife();
			}
		}
	}

	@Override
	public void makeMove(Location loc) {
		if (loc == null)
			removeSelfFromGrid();
		else {
			moveTo(loc);
		}

	}

	private boolean canMove(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		if(getGrid().get(loc) == null) {
			return true;
		}
		if (!gr.isValid(loc))
			return false;
		Actor neighbor = gr.get(loc);
		return (neighbor == null) || (neighbor instanceof Heart) || (neighbor instanceof Flower);
	}
}
