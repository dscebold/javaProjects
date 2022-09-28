package GridWorldCritters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class FlashyBug extends Bug{
	
	protected Color[] colors = {new Color(255,0,0), new Color(0,255,0), new Color(0,0,255)};
	protected int count;
	
	public FlashyBug(int count) {
	this.count = count;
	setColor(colors[count]);
	}
	
	@Override
	public void act() {
		count++;
		if(count == colors.length) {
			count = 0;
		}
		setColor(colors[count]);
		ArrayList<Location> loc = getGrid().getEmptyAdjacentLocations(getLocation());
			//creates an arraylist of all empty locations around this bug
		for(Location aLoc: loc) {
			new FlashyBug(count).putSelfInGrid(getGrid(), aLoc);
		}
	}

}
