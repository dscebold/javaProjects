package GridWorldCritters;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class GlitchCritter extends Critter{
	
	//Attributes
		protected Random rand;
		
	//Constructor
		public GlitchCritter() {
			setColor(Color.GREEN);
			rand = new Random();
		}
		
		public GlitchCritter(Location loc) {
			setColor(Color.GREEN);
			rand = new Random();
			moveTo(loc);
		}
		
		
	//Methods
		@Override
		public void act() {
			super.act();  //move and process actors like a critter
			if(rand.nextInt(6) == 1) {
				glitch();  //shake everything and replace self with next glitch critter
			}
		}

	public void glitch() {
		ArrayList<Location> locs = getGrid().getOccupiedLocations(); // every actors on the grids location
		for(Location loc : locs) {
			if(getGrid().get(loc).equals(this)) { // if this actor do nothing
				continue;
			}
			else {
				shake(getGrid().get(loc)); // otherwise pass the actor to another method
			}
		}
		nextGlitch(); // call the method to place a new GlitchCritter and remove this one.
	}

	public void nextGlitch() {
		Location randLoc = null; //null location
		int justInCase = 100; //number of times it will look
		while(randLoc == null && justInCase > 0) { // while no location has been picked or max locs
			randLoc = new Location(rand.nextInt(getGrid().getNumRows()), rand.nextInt(getGrid().getNumCols()));
			if(getGrid().get(randLoc) != null) { // if there is an actor at the random loc
				randLoc = null; // set it back to null
			}
			justInCase--;
		}
		Location origin = getLocation(); // save the start location
		if(randLoc == null) {
			moveTo(getLocation()); // stay put if no random location found
		}
		else {
			moveTo(randLoc); //hopefully move to the random location
		}
		
		placeNext(origin);
	}
	public void placeNext(Location origin) {
		new GlitchCritterGlitchTwo(origin).putSelfInGrid(getGrid(),getLocation()); //places the next image on the grid
	}

	private void shake(Actor actor) {
		for(int i = 0; i < 3 ; i++) {
			if(rand.nextBoolean()) {
				actor.setDirection(Location.EAST);
			}
			else {
				actor.setDirection(Location.WEST);
			}
			Location next = actor.getLocation().getAdjacentLocation(actor.getDirection());
			if(getGrid().isValid(next) && getGrid().get(next) == null) {
				actor.moveTo(next);
			}
		}
		
	}

}
