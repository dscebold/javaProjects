package GridWorldCritters;

import info.gridworld.grid.Location;

public class GlitchCritterGlitchFour extends GlitchCritterGlitchThree{
	
	public GlitchCritterGlitchFour(Location loc) {
		super(loc);
	}
	
	
	@Override
	public void placeNext(Location origin) {
		new GlitchCritter().putSelfInGrid(getGrid(),this.locToBePassed); //places the next image on the grid
		if(this.getGrid() != null)
			this.removeSelfFromGrid();
	}
}
