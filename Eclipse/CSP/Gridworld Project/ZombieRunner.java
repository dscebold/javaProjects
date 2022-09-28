package GridWorldB;

import info.gridworld.grid.BoundedGrid;

public class ZombieRunner {

	public static void main(String[] args) {
		ZombieWorld world = new ZombieWorld(new BoundedGrid<>(200, 200));
		Survivor julien = new Survivor();
		world.add(julien);
		world.show();
		

	}

}
