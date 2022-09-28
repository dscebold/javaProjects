package GridWorldCritters;

import info.gridworld.grid.Location;

public class GlitchCritterGlitchThree extends GlitchCritterGlitchTwo{
	
	public GlitchCritterGlitchThree(Location loc) {
		super(loc);
	}
	
	@Override
	public void placeNext(Location origin) {
		new GlitchCritterGlitchFour(origin).putSelfInGrid(getGrid(),getLocation()); //places the next image on the grid
	}

}
