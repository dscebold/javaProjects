package GridWorldCritters;

import java.util.ArrayList;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class HydraBug extends Bug{
	
	 public void removeSelfFromGrid() {
		 ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(this.getLocation());
		 int count = 0;
		 for(Location loc : locs) {
			 count++;
			 
			 if(count > 2) {
				 break;
			 }
			 HydraBug h = new HydraBug();
			 h.putSelfInGrid(getGrid(), loc);
		 }
		 super.removeSelfFromGrid();
	 }

}
