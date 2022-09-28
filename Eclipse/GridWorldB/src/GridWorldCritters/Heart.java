package GridWorldCritters;

import java.awt.Color;

import info.gridworld.actor.Flower;

public class Heart extends Flower{
	
	//Attributes
		private int count;
		private Color[] colors = {
				new Color(75, 0, 130), //light purple
				new Color(148, 0, 211), //purple
				Color.BLUE,
				Color.GREEN,
				Color.YELLOW,
				Color.ORANGE,
				Color.RED
		};
		
	//Constructor
		public Heart(int num) {
			count = num;
			setColor(colors[count]);
		}
		
		public void act() {
			if(getGrid() == null) {
				return;
			}
			count--;
			if(count > -1) {
				setColor(colors[count]);
			}
			else {
				removeSelfFromGrid();
			}
		}

}
