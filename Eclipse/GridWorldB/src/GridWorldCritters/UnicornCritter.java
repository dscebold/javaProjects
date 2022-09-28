package GridWorldCritters;

import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class UnicornCritter extends Bug {

	// Attributes
	private int moveCount;
	private Random rand;

	// Constructor
	public UnicornCritter() {
		rand = new Random();
		moveCount = 0;
	}

	// Methods
	@Override
	public void act() {
		if (getGrid() == null) {
			return;
		}
		if (canMove() && moveCount < 7) { // Stolen from boxbug
			move();
			moveCount++;
		} 
		else {
			for (int i = 0; i < rand.nextInt(8); i++) { // Rand number of turning
				turn();
			}
			if(rand.nextInt(5) == 1) { //1/5 chance to dash
				for(int i = 0; i < rand.nextInt(21) +10; i++) {
					if(canMove()) {
						move();
					}
					if(rand.nextInt(4) == 1) { //1/4 chance of turning mid dash
						turn();
					}
				}
			}
			moveCount = 0;
		}
		if(rand.nextInt(301) == 1) { // 1/300 chance of filling the grid with hearts
			fillGrid();
		}
	}

	private void fillGrid() {
		for(int i = 0 ; i <getGrid().getNumRows(); i++) { //checks all rows
			for(int z = 0; z < getGrid().getNumCols(); z++) {
				Location loc = new Location(i,z); //makes a current location at the current loc
				if(getGrid().get(loc) == null) { // is the current loc unoccupied?
					new Heart(6).putSelfInGrid(getGrid(), loc);
					
				}
			}
		}
	}
	
	@Override
	public void move() {
		super.move();
		Location lastLoc = getLocation().getAdjacentLocation(getDirection() - 180);
		if(getGrid().isValid(lastLoc)) {
			new Heart(6).putSelfInGrid(getGrid(), lastLoc);
		}
	}

}
