package GridWorldB;

import java.util.Random;

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Building extends Bug {
	
	private Random rand;

	public Building() {
		super();
		rand = new Random();
	}

	@Override
	public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Rock rock = new Rock();
        rock.putSelfInGrid(gr, loc);
    }
	
	public void step(int num) {
		for(int i = 0; i < num; i++) {
			if(canMove()) {
				move();
			}
		}
	}
	
	@Override
	public void act() {
		setDirection(rand.nextInt());
		int size = rand.nextInt(11) + 5; 
		step(size);
		turn();
		turn();
		step(size);
		turn();
		turn();
		step(size);
		turn();
		turn();
		step(size - 2);
		removeSelfFromGrid();
	}
	
	
}
