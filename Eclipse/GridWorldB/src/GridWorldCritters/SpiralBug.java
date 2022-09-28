package GridWorldCritters;

import info.gridworld.actor.Bug;

public class SpiralBug extends BoxBug{
	
	//Attributes
	
	//Constructor
	
	public SpiralBug(int length) {
		super(length);
		steps = 0;
		sideLength = length;
	}
	
	//Methods
	
	 public void act() {
	        if (steps < sideLength && canMove())
	        {
	            move();
	            steps++;
	        }
	        else
	        {
	            turn();
	            turn();
	            steps = 0;
	            sideLength++;
	        }
	    }

}
