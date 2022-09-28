package GridWorldB;

import java.awt.Color;

import GridWorldCritters.Heart;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.gui.GridPanel;
import info.gridworld.gui.WorldFrame;
import info.gridworld.world.World;

public class Survivor extends Actor {

	private int life;
	private boolean alive;

	public Survivor() {
		super();
		setColor(Color.GRAY);
		life = 50;
		alive = true;
	}

	@Override
	public void act() {
		if (alive) {
			if (WorldFrame.left || WorldFrame.up || WorldFrame.down || WorldFrame.right || WorldFrame.fire) {
				if (WorldFrame.left && WorldFrame.down) {
					this.setDirection(Location.SOUTHWEST);
				} else if (WorldFrame.left && WorldFrame.up) {
					this.setDirection(Location.NORTHWEST);
				} else if (WorldFrame.right && WorldFrame.down) {
					this.setDirection(Location.SOUTHEAST);
				} else if (WorldFrame.right && WorldFrame.up) {
					this.setDirection(Location.NORTHEAST);
				} else if (WorldFrame.left) {
					this.setDirection(Location.WEST);
				} else if (WorldFrame.right) {
					this.setDirection(Location.EAST);
				} else if (WorldFrame.down) {
					this.setDirection(Location.SOUTH);
				} else if (WorldFrame.up) {
					this.setDirection(Location.NORTH);
				}
				if (canMove() && (WorldFrame.down || WorldFrame.up || WorldFrame.left || WorldFrame.right)) {
					move();
				}
				if (WorldFrame.fire) {
					Location bullet = getLocation().getAdjacentLocation(getDirection());
					if (getGrid().isValid(bullet) && (getGrid().get(bullet) == null || !(getGrid().get(bullet) instanceof Rock))) {
						Bullet bill = new Bullet();
						bill.putSelfInGrid(getGrid(), bullet);
						bill.setDirection(getDirection());
					}
				}
				WorldFrame.left = false;
				WorldFrame.up = false;
				WorldFrame.down = false;
				WorldFrame.right = false;
				WorldFrame.fire = false;

			}
			setAlive();
		}
		else {
			removeSelfFromGrid();
		}
	}

	private void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (gr.isValid(next)) {
			moveTo(next);
			GridPanel.setCurrentLocation(next);
		} else
			removeSelfFromGrid();

	}

	private boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		Actor neighbor = gr.get(next);
		return (neighbor == null) || (neighbor instanceof Flower);
	}
	
	public void setLife() {
		this.life--;
		setAlive();
	}
	
	
	private void setAlive() {
		if(this.life <= 0) {
			this.alive = false;
		}
		else {
			this.alive = true;
		}
	}
	
	public int getLife() {
		return this.life;
	}

}
 