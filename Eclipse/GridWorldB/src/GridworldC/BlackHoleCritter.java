package GridworldC;

import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BlackHoleCritter extends Critter{
	
	//Attributes
	private boolean firstRun;
	private int count;
	private Random rand;
	//Constructor
	public BlackHoleCritter() {
		super();
		firstRun = true;
		count = 0;
		rand = new Random();
	}
	//Methods
	
	@Override
	public void act() {
		while(firstRun) {
			Location loc = new Location(this.getLocation().getRow()+1, this.getLocation().getCol()-1);
			if(getGrid().isValid(loc)) {
				RingCritter bob = new RingCritter(2);
				bob.putSelfInGrid(getGrid(), loc);
				bob.setDirection(0);
				firstRun = false;
			}
		}
		ArrayList<Actor> pullActors = getActor();
		pull(pullActors);
		remove(pullActors);
		beam();
	}
	
	private void beam() {
		if(this.count >= 3) {
			BeamCritter beamy = new BeamCritter();
			//place beamy
			Location beamyLoc = selectMoveLocation(getGrid().getEmptyAdjacentLocations(getLocation()));
			beamy.putSelfInGrid(getGrid(), beamyLoc);
			beamy.setDirection(rand.nextInt(361));
			this.count = 0;
		}
		
	}
	private void remove(ArrayList<Actor> pullActors) {
		for(Actor a : pullActors) {
			if(a.getGrid() != null && saveDist(a) <= 2 && !(a instanceof RingCritter) && !(a instanceof BeamCritter)) {
				a.removeSelfFromGrid();
				count++;
			}
		}
		
		
	}
	private double saveDist(Actor a) {
		return Math.sqrt(
				Math.pow(a.getLocation().getCol() - this.getLocation().getCol(), 2)
				+ 
				Math.pow(a.getLocation().getRow() - this.getLocation().getRow(), 2)
				);
	}

	private ArrayList<Actor> getActor() {
		ArrayList<Location> allLocs = getGrid().getOccupiedLocations(); // saved all locations with an actor
		ArrayList<Actor> allActors = new ArrayList<Actor>();
		for (Location loc : allLocs) { // looks at every location
			Actor temp = getGrid().get(loc); // saves the current actor
			if (!(temp instanceof BeamCritter) && !(temp.equals(this)) && !(temp instanceof RingCritter)) {
				allActors.add(temp);
			}
		}
		return allActors;
	}
	private void pull(ArrayList<Actor> pullActors) {
		
		for(Actor a : pullActors) {
			a.setDirection(a.getLocation().getDirectionToward(getLocation()));
			for(int i = 0; i < 2; i++) {
				Location loc = a.getLocation();
				Location next = loc.getAdjacentLocation(a.getDirection());
				if(getGrid().isValid(next) && getGrid().get(next) == null)
					a.moveTo(next);
			}
		}
		
		
	}

}