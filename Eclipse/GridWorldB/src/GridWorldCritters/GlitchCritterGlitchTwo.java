package GridWorldCritters;

import info.gridworld.grid.Location;

public class GlitchCritterGlitchTwo extends GlitchCritter{ 
	
	//Attributes
	protected Location locToBePassed;
	
	
	//Constructor
	public GlitchCritterGlitchTwo(Location loc) {
		super();
		locToBePassed = loc;
	}
	
	@Override
	public void act() {
		if(getGrid() == null) {
			return;
		}
		glitch();
	}
	
	@Override
	public void placeNext(Location origin) {
		new GlitchCritterGlitchThree(origin).putSelfInGrid(getGrid(),getLocation()); //places the next image on the grid
	}

}
