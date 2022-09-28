package GridWorldCritters;

import info.gridworld.grid.Location;

public class ZBug extends SpiralBug{
	
	protected int count;

	public ZBug(int length) {
		super(length);
	}
	
	
	@Override
	public void act() {
		if(count == 0) {
			setDirection(Location.EAST);
			count++;
		}
		if(steps < sideLength && canMove()) {
			move();
			steps++;
		}
		else if(count == 1) {
			setDirection(Location.SOUTHWEST);
			count++;
			steps = 0;
		}
		else if(count == 2) {
			setDirection(Location.EAST);
			count++;
			steps = 0;
		}
		else {
			turn();
		}
	}

}