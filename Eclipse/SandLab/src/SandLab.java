
import java.awt.*;
import java.util.*;

public class SandLab {
	public static void main(String[] args) {
		SandLab lab = new SandLab(120, 80);
		lab.run();
	}

	// add constants for particle types here
	public static final int EMPTY = 0;
	public static final int METAL = 1;
	public static final int SAND = 2;
	public static final int WATER = 3;
	public static final int LAVA = 4;
	public static final int STEAM = 5;
	public static final int SNOW = 6;
	public static int memory = 7;
	public static final int ICE = 8;
	public static int randomize = 9;
	public static final int SEIZURE = 10;
	public static final int ACID = 11;
	public static int surprise = 12;
	public static final int CLONE = 13;
	public static final int SODA = 14; 
	public static int clear = 15; 
	public static final int LOOPYSAND = 16; 
	public static String[] names;

	// do not add any more fields
	private int[][] grid;
	private SandDisplay display;
	private HashMap<Integer, Color> colors;
	Random rand;
	private int gravity, spawn;

	public SandLab(int numRows, int numCols) {
		names = new String[17];
		names[EMPTY] = "Empty";
		names[METAL] = "Metal";
		names[SAND] = "Sand";
		names[WATER] = "Water";
		names[LAVA] = "Lava";
		names[STEAM] = "Steam";
		names[SNOW] = "Snow";
		names[memory] = "Invert";
		names[ICE] = "Ice";
		names[randomize] = "Randomize";
		names[SEIZURE] = "Seizure Sand";
		names[ACID] = "Acid";
		names[surprise] = "Surprise Me";
		names[CLONE] = "Clone";
		names[SODA] = "Baking Soda"; 
		names[clear] = "Clear"; 
		names[LOOPYSAND] = "Loopy Sand"; 
		display = new SandDisplay("Falling Sand", numRows, numCols, names);
		grid = new int[numRows][numCols];
		colors = new HashMap<>();
		colors.put(1, Color.GRAY);
		colors.put(2, new Color(245, 238, 91));
		colors.put(3, new Color(58, 16, 189));
		colors.put(4, new Color(240, 142, 39));
		colors.put(5, new Color(251, 248, 245));
		colors.put(6, new Color(255, 255, 255));
		colors.put(8, new Color(156, 246, 255));
		colors.put(10, Color.YELLOW);
		colors.put(11, new Color(56, 255, 20));
		colors.put(12, Color.YELLOW);
		colors.put(16, new Color(245, 238, 91)); 
		rand = new Random();
		gravity = 1;
		spawn = 0; 
	}

	// called when the user clicks on a location using the given tool
	private void locationClicked(int row, int col, int tool) {
		grid[row][col] = tool;

	}

	// copies each element of grid into the display
	public void updateDisplay() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 12) {
					int bubble = rand.nextInt(names.length);
					while (bubble == 7 || bubble == 9 || bubble == 12) {
						bubble = rand.nextInt(names.length);
					}
					grid[i][j] = bubble;
				}
				if(grid[i][j] == 7 || grid[i][j] == 9 || grid[i][j] == 12 || grid[i][j] == 15) {
					grid[i][j] = 0; 
				}

				if (grid[i][j] > 0) {

					display.setColor(i, j, colors.get(grid[i][j]));

				} else {
					display.setColor(i, j, Color.BLACK);
				}
			}
		}
	}

	public void step() {
		int wid = rand.nextInt(grid.length);
		int hei = rand.nextInt(grid[0].length);
		if (grid[wid][hei] == 2) {
			sandMove(wid, hei);
		} else if (grid[wid][hei] == 3) {
			waterMove(wid, hei);
		} else if (grid[wid][hei] == 4) {
			lavaMove(wid, hei);
		} else if (grid[wid][hei] == 5) {
			steamMove(wid, hei);
		} else if (grid[wid][hei] == 6) {
			if (rand.nextInt(4) == 1) {
				snowMove(wid, hei);
			}
		} else if (grid[wid][hei] == 8) {
			iceMove(wid, hei);
		} else if (grid[wid][hei] == 10) {
			seizureMove(wid, hei);
		} else if (grid[wid][hei] == 11) {
			AcidMove(wid, hei);
		} else if (grid[wid][hei] == 13) {
			cloneMove(wid, hei);
		}
		else if(grid[wid][hei] == 14) {
			sodaMove(wid, hei);
		}
		else if(grid[wid][hei] == 16) {
			loopySandMove(wid, hei);
		}
	}

	private void loopySandMove(int up, int right) {
		if (isValid(gravity, up, right) && grid[up + gravity][right] == 0) {
			grid[up + gravity][right] = grid[up][right];
			grid[up][right] = 0;

		}
		else if(loop(gravity, up, right) && !isValid(gravity, up, right)) {
			grid[loopty(gravity, up, right)][right] = grid[up][right];
			grid[up][right] = 0;
		}
		if (isValid(gravity, up, right) && (grid[up + gravity][right] == 3 || grid[up + gravity][right] == 4)) {
			grid[up][right] = grid[up + gravity][right];
			grid[up + gravity][right] = 2;

		}
		if (isValid(gravity, up, right) && grid[up + gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up + gravity][right - 1] == 0 && grid[up + gravity][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up + gravity][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up + gravity][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up + gravity][right + 1] != 0 && grid[up + gravity][right - 1] == 0) {
					grid[up + gravity][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up + gravity][right + 1] == 0 && grid[up + gravity][right - 1] != 0) {
					grid[up + gravity][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}
		if (isValid(2, up, right) && !(isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right - 1] == 0) {
				grid[up + gravity][right - 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		if (!isValid(2, up, right) && (isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right + 1] == 0) {
				grid[up + gravity][right + 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		
	}

	private void sodaMove(int up, int right) {
		if (isValid(gravity, up, right) && grid[up + gravity][right] == 0) {
			grid[up + gravity][right] = grid[up][right];
			grid[up][right] = 0;

		}
		if (isValid(gravity, up, right) && (grid[up + gravity][right] == 3 || grid[up + gravity][right] == 4)) {
			grid[up][right] = grid[up + gravity][right];
			grid[up + gravity][right] = 14;

		}
		else if (isValid(gravity, up, right) && grid[up + gravity][right] == 11) {
			grid[up + gravity][right] = 2;
			grid[up][right] = 5;

		} else if (isValid(gravity, up, right) && grid[up + gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up + gravity][right - 1] == 0 && grid[up + gravity][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up + gravity][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up + gravity][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up + gravity][right + 1] != 0 && grid[up + gravity][right - 1] == 0) {
					grid[up + gravity][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up + gravity][right + 1] == 0 && grid[up + gravity][right - 1] != 0) {
					grid[up + gravity][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}
		if (isValid(2, up, right) && !(isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right - 1] == 0) {
				grid[up + gravity][right - 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		if (!isValid(2, up, right) && (isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right + 1] == 0) {
				grid[up + gravity][right + 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		
	}

	private void cloneMove(int up, int right) {
		if (isValid(-gravity, up, right) && isValid(2, up, right) && grid[up - gravity][right - 1] != 0 && grid[up - gravity][right - 1] != 13) {
			spawn = grid[up - gravity][right - 1];
		}
		if (isValid(-gravity, up, right) && grid[up - gravity][right] != 0 && grid[up - gravity][right] != 13) {
			spawn = grid[up - gravity][right] = 13;
		}
		if (isValid(-gravity, up, right) && isValid(3, up, right) && grid[up - gravity][right + 1] != 0 && grid[up - gravity][right + 1] != 13) {
			spawn = grid[up - gravity][right + 1];
		}
		if (isValid(2, up, right) && grid[up][right - 1] != 0 && grid[up][right - 1] != 13) {
			spawn = grid[up][right - 1];
		}
		if (isValid(3, up, right) && grid[up][right + 1] != 0 && grid[up][right + 1] != 13) {
			spawn = grid[up][right + 1];
		}
		if (isValid(gravity, up, right) && isValid(2, up, right) && grid[up + gravity][right - 1] != 0 && grid[up + gravity][right - 1] != 13) {
			spawn = grid[up + gravity][right - 1];
		}
		if (isValid(gravity, up, right) && grid[up + gravity][right] != 0 && grid[up + gravity][right] != 13) {
			spawn = grid[up + gravity][right];
		}
		if (isValid(gravity, up, right) && isValid(3, up, right) && grid[up + gravity][right + 1] != 0 && grid[up + gravity][right + 1] != 13) {
			spawn = grid[up + gravity][right + 1];
		}

		if (isValid(gravity, up, right)) {
			grid[up + gravity][right] = spawn;
		}
		//System.out.println(spawn);
		colors.put(13, new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
	}

	private void AcidMove(int up, int right) {
		if (isValid(gravity, up, right) && grid[up + gravity][right] == 0) {
			grid[up + gravity][right] = grid[up][right];
			grid[up][right] = 0;
		} else if (isValid(gravity, up, right) && grid[up + gravity][right] == 14) {
			grid[up + gravity][right] = 2;
			grid[up][right] = 5;

		}else if (isValid(gravity, up, right) && grid[up + gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right - 1] == 0 && grid[up][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up][right + 1] != 0 && grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up][right + 1] == 0 && grid[up][right - 1] != 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
			if (isValid(2, up, right) && !isValid(3, up, right)) {
				if (grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
			if (!isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right + 1] == 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}

		} else if (!isValid(gravity, up, right)) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right - 1] == 0 && grid[up][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up][right + 1] != 0 && grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up][right + 1] == 0 && grid[up][right - 1] != 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}
		if (rand.nextInt(100) == 1) {
			if (isValid(-gravity, up, right) && isValid(2, up, right) && grid[up - gravity][right - 1] != 11 && grid[up - gravity][right - 1] != 14 && grid[up - gravity][right - 1] != 3) {
				grid[up - gravity][right - 1] = 0;
			}
			if (isValid(-gravity, up, right) && grid[up - gravity][right] != 11 && grid[up - gravity][right] != 14 && grid[up - gravity][right] != 3) {
				grid[up - gravity][right] = 0;
			}
			if (isValid(-gravity, up, right) && isValid(3, up, right) && grid[up - gravity][right + 1] != 11 && grid[up - gravity][right + 1] != 14 && grid[up - gravity][right + 1] != 3) {
				grid[up - gravity][right + 1] = 0;
			}
			if (isValid(2, up, right) && grid[up][right - 1] != 11 && grid[up][right - 1] != 14 && grid[up][right - 1] != 3) {
				grid[up][right - 1] = 0;
			}
			if (isValid(3, up, right) && grid[up][right + 1] != 11 && grid[up][right + 1] != 14 && grid[up][right + 1] != 3) {
				grid[up][right + 1] = 0;
			}
			if (isValid(gravity, up, right) && isValid(2, up, right) && grid[up + gravity][right - 1] != 11 && grid[up + gravity][right - 1] != 14 && grid[up + gravity][right - 1] != 3) {
				grid[up + gravity][right - 1] = 0;
			}
			if (isValid(gravity, up, right) && grid[up + gravity][right] != 11 && grid[up + gravity][right] != 14 && grid[up + gravity][right] != 3) {
				grid[up + gravity][right] = 0;
			}
			if (isValid(gravity, up, right) && isValid(3, up, right) && grid[up + gravity][right + 1] != 11 && grid[up + gravity][right + 1] != 14 && grid[up + gravity][right + 1] != 3) {
				grid[up + gravity][right + 1] = 0;
			}
		}

	}

	private void seizureMove(int up, int right) {
		if (isValid(gravity, up, right) && grid[up + gravity][right] == 0) {
			grid[up + gravity][right] = grid[up][right];
			grid[up][right] = 0;

		}
		if (isValid(gravity, up, right) && (grid[up + gravity][right] == 3 || grid[up + gravity][right] == 4)) {
			grid[up][right] = grid[up + gravity][right];
			grid[up + gravity][right] = 2;

		}
		if (isValid(gravity, up, right) && grid[up + gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up + gravity][right - 1] == 0 && grid[up + gravity][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up + gravity][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up + gravity][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up + gravity][right + 1] != 0 && grid[up + gravity][right - 1] == 0) {
					grid[up + gravity][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up + gravity][right + 1] == 0 && grid[up + gravity][right - 1] != 0) {
					grid[up + gravity][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}
		if (isValid(2, up, right) && !(isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right - 1] == 0) {
				grid[up + gravity][right - 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		if (!isValid(2, up, right) && (isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right + 1] == 0) {
				grid[up + gravity][right + 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		colors.put(10, new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

	}

	private void iceMove(int up, int right) {
		if (isValid(gravity, up, right)) {
			if (grid[up + gravity][right] == 0) {
				grid[up + gravity][right] = 8;
				grid[up][right] = 0;
			}
		}
		if (rand.nextInt(100) == 1) {
			if (isValid(gravity, up, right) && grid[up + gravity][right] == 3) {
				grid[up + gravity][right] = 8;
			}
			if (isValid(gravity, up, right) && isValid(2, up, right) && grid[up + gravity][right - 1] == 3) {
				grid[up + gravity][right - 1] = 8;
			}
			if (isValid(gravity, up, right) && isValid(3, up, right) && grid[up + gravity][right + 1] == 3) {
				grid[up + gravity][right + 1] = 8;
			}
			if (isValid(-gravity, up, right) && isValid(2, up, right) && grid[up - gravity][right - 1] == 3) {
				grid[up - gravity][right - 1] = 8;
			}
			if (isValid(-gravity, up, right) && grid[up - gravity][right] == 3) {
				grid[up - gravity][right] = 8;
			}
			if (isValid(-gravity, up, right) && isValid(3, up, right) && grid[up - gravity][right + 1] == 3) {
				grid[up - gravity][right + 1] = 8;
			}
			if (isValid(2, up, right) && grid[up][right - 1] == 3) {
				grid[up][right - 1] = 8;
			}
			if (isValid(3, up, right) && grid[up][right + 1] == 3) {
				grid[up][right + 1] = 8;
			}
		}

	}

	private void snowMove(int up, int right) {
		if (isValid(gravity, up, right)) {
			if (isValid(2, up, right) && isValid(3, up, right) && (grid[up + gravity][right] == 6
					|| grid[up + gravity][right + 1] == 6 || grid[up + gravity][right - 1] == 6)) {

			} else if (isValid(2, up, right) && !isValid(3, up, right)
					&& (grid[up + gravity][right] == 6 || grid[up + gravity][right - 1] == 6)) {

			} else if (!isValid(2, up, right) && isValid(3, up, right)
					&& (grid[up + gravity][right] == 6 || grid[up + gravity][right + 1] == 6)) {
			} else if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up + gravity][right + 1] == 0 && grid[up + gravity][right - 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up + gravity][right - 1] = 6;
						grid[up][right] = 0;
					} else {
						grid[up + gravity][right + 1] = 6;
						grid[up][right] = 0;
					}
				} else if (grid[up + gravity][right + 1] == 0 && grid[up + gravity][right - 1] != 0) {
					grid[up + gravity][right + 1] = 6;
					grid[up][right] = 0;
				} else if (grid[up + gravity][right + 1] != 0 && grid[up + gravity][right - 1] == 0) {
					grid[up + gravity][right - 1] = 6;
					grid[up][right] = 0;
				}
			} else if (isValid(2, up, right) && !isValid(3, up, right)) {
				if (grid[up + gravity][right - 1] == 0) {
					grid[up + gravity][right - 1] = 6;
					grid[up][right] = 0;
				}
			} else if (!isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up + gravity][right + 1] == 0) {
					grid[up + gravity][right + 1] = 6;
					grid[up][right] = 0;
				}
			}
		}
		if (rand.nextInt(100) == 1) {
			if (isValid(gravity, up, right) && grid[up + gravity][right] == 3) {
				grid[up + gravity][right] = 8;
			}
			if (isValid(gravity, up, right) && isValid(2, up, right) && grid[up + gravity][right - 1] == 3) {
				grid[up + gravity][right + 1] = 8;
			}
			if (isValid(gravity, up, right) && isValid(3, up, right) && grid[up + gravity][right + 1] == 3) {
				grid[up + gravity][right + 1] = 8;
			}
			if (isValid(-gravity, up, right) && isValid(3, up, right) && grid[up - gravity][right + 1] == 3) {
				grid[up - gravity][right + 1] = 8;
			}
			if (isValid(-gravity, up, right) && grid[up - gravity][right] == 3) {
				grid[up - gravity][right] = 8;
			}
			if (isValid(-gravity, up, right) && isValid(2, up, right) && grid[up - gravity][right - 1] == 3) {
				grid[up - gravity][right - 1] = 8;
			}
			if (isValid(2, up, right) && grid[up][right - 1] == 3) {
				grid[up][right - 1] = 8;
			}
			if (isValid(3, up, right) && grid[up][right + 1] == 3) {
				grid[up][right + 1] = 8;
			}
		}

	}

	private void steamMove(int up, int right) {
		if (isValid(-gravity, up, right) && grid[up - gravity][right] == 0) {
			grid[up - gravity][right] = grid[up][right];
			grid[up][right] = 0;

		} else if (isValid(-gravity, up, right) && grid[up - gravity][right] == 3) {
			grid[up][right] = 3;
		}
		if (isValid(-gravity, up, right) && grid[up - gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right - 1] == 0 && grid[up][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up][right + 1] != 0 && grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up][right + 1] == 0 && grid[up][right - 1] != 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		} else if (!isValid(-gravity, up, right)) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right - 1] == 0 && grid[up][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up][right + 1] != 0 && grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up][right + 1] == 0 && grid[up][right - 1] != 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}
		if (isValid(2, up, right) && isValid(-gravity, up, right) && isValid(3, up, right)
				&& isValid(gravity, up, right)) {
			if (grid[up - gravity][right - 1] == 5 && grid[up - gravity][right] == 5
					&& grid[up - gravity][right + 1] == 5 && grid[up][right - 1] == 5 && grid[up][right + 1] == 5
					&& grid[up + gravity][right - 1] == 5 && grid[up + gravity][right] == 5
					&& grid[up + gravity][right + 1] == 5) {
				grid[up][right] = 3;
			}

		}

	}

	private void lavaMove(int up, int right) {
		if (isValid(gravity, up, right) && grid[up + gravity][right] == 0) {
			grid[up + gravity][right] = grid[up][right];
			grid[up][right] = 0;

		} else if (isValid(gravity, up, right) && grid[up + gravity][right] == 3) {
			grid[up + gravity][right] = 2;
			grid[up][right] = 5;

		} else if (isValid(gravity, up, right) && grid[up + gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up + gravity][right - 1] == 0 && grid[up + gravity][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up + gravity][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up + gravity][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up + gravity][right + 1] != 0 && grid[up + gravity][right - 1] == 0) {
					grid[up + gravity][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up + gravity][right + 1] == 0 && grid[up + gravity][right - 1] != 0) {
					grid[up + gravity][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}
		if (isValid(2, up, right) && !(isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right - 1] == 0) {
				grid[up + gravity][right - 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		if (!isValid(2, up, right) && (isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right + 1] == 0) {
				grid[up + gravity][right + 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		if (isValid(gravity, up, right) && grid[up + gravity][right] == 0) {
			grid[up + gravity][right] = grid[up][right];
			grid[up][right] = 0;
		} else if (isValid(gravity, up, right) && grid[up + gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right - 1] == 0 && grid[up][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up][right + 1] != 0 && grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up][right + 1] == 0 && grid[up][right - 1] != 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		} else if (!isValid(gravity, up, right)) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right - 1] == 0 && grid[up][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up][right + 1] != 0 && grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up][right + 1] == 0 && grid[up][right - 1] != 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}
		if (rand.nextInt(100) == 1) {
			if (isValid(-gravity, up, right) && isValid(2, up, right) && grid[up - gravity][right - 1] == 1) {
				grid[up - gravity][right - 1] = 4;
			}
			if (isValid(-gravity, up, right) && grid[up - gravity][right] == 1) {
				grid[up - gravity][right] = 4;
			}
			if (isValid(-gravity, up, right) && isValid(3, up, right) && grid[up - gravity][right + 1] == 1) {
				grid[up - gravity][right + 1] = 4;
			}
			if (isValid(2, up, right) && grid[up][right - 1] == 1) {
				grid[up][right - 1] = 4;
			}
			if (isValid(3, up, right) && grid[up][right + 1] == 1) {
				grid[up][right + 1] = 4;
			}
			if (isValid(gravity, up, right) && isValid(2, up, right) && grid[up + gravity][right - 1] == 1) {
				grid[up + gravity][right - 1] = 4;
			}
			if (isValid(gravity, up, right) && grid[up + gravity][right] == 1) {
				grid[up - gravity][right] = 4;
			}
			if (isValid(gravity, up, right) && isValid(3, up, right) && grid[up + gravity][right + 1] == 1) {
				grid[up + gravity][right + 1] = 4;
			}
		}
		if (rand.nextInt(100) == 1) {
			if (isValid(gravity, up, right) && grid[up + gravity][right] == 6) {
				grid[up + gravity][right] = 3;
			}

			if (isValid(gravity, up, right) && isValid(2, up, right) && grid[up + gravity][right - 1] == 6) {
				grid[up + gravity][right - 1] = 3;
			}
			if (isValid(gravity, up, right) && isValid(3, up, right) && grid[up + gravity][right + 1] == 6) {
				grid[up + gravity][right + 1] = 3;
			}
			if (isValid(-gravity, up, right) && isValid(3, up, right) && grid[up - gravity][right + 1] == 6) {
				grid[up - gravity][right + 1] = 3;
			}

			if (isValid(-gravity, up, right) && isValid(2, up, right) && grid[up - gravity][right - 1] == 6) {
				grid[up - gravity][right - 1] = 3;
			}
			if (isValid(-gravity, up, right) && grid[up - gravity][right] == 1) {
				grid[up - gravity][right] = 3;
			}
			if (isValid(2, up, right) && grid[up][right - 1] == 6) {
				grid[up][right - 1] = 3;
			}
			if (isValid(3, up, right) && grid[up][right + 1] == 6) {
				grid[up][right + 1] = 3;
			}

		}

	}

	private void waterMove(int up, int right) {
		if (isValid(gravity, up, right) && grid[up + gravity][right] == 0) {
			grid[up + gravity][right] = grid[up][right];
			grid[up][right] = 0;
		} else if (isValid(gravity, up, right) && grid[up + gravity][right] == 4) {
			grid[up + gravity][right] = 2;
			grid[up][right] = 5;
		} else if (isValid(gravity, up, right) && grid[up + gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right - 1] == 0 && grid[up][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up][right + 1] != 0 && grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up][right + 1] == 0 && grid[up][right - 1] != 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
			if (isValid(2, up, right) && !isValid(3, up, right)) {
				if (grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
			if (!isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right + 1] == 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}

		} else if (!isValid(gravity, up, right)) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up][right - 1] == 0 && grid[up][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up][right + 1] != 0 && grid[up][right - 1] == 0) {
					grid[up][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up][right + 1] == 0 && grid[up][right - 1] != 0) {
					grid[up][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}

	}

	// do not modify
	public void run() {
		while (true) {
			for (int i = 0; i < display.getSpeed(); i++)
				step();
			updateDisplay();
			display.repaint();
			display.pause(1); // wait for redrawing and for mouse
			int[] mouseLoc = display.getMouseLocation();
			if (mouseLoc != null) // test if mouse clicked
				locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
			if (display.getTool() != memory && display.getTool() == 7) {
				gravity = setGravity(); ////////////////////////////////////

			}
			if (display.getTool() != memory && display.getTool() == 9) {
				randomize();

			}
			if(display.getTool() != memory && display.getTool() == 15) {
				emptyScreen(); 
			}
			memory = display.getTool();
		}
	}

	private void emptyScreen() {
		for(int i = 0; i < grid.length; i++) {
			for(int q = 0; q < grid[i].length; q++) {
				grid[i][q] = 0; 
			}
		}
		
	}

	private void randomize() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int bubble = rand.nextInt(names.length);
				while (bubble == 7 || bubble == 9) {
					bubble = rand.nextInt(names.length);
				}
				grid[i][j] = bubble;
			}
		}

	}

	private int setGravity() {
		return gravity * -1;

	}

	private void sandMove(int up, int right) {
		if (isValid(gravity, up, right) && grid[up + gravity][right] == 0) {
			grid[up + gravity][right] = grid[up][right];
			grid[up][right] = 0;

		}
		if (isValid(gravity, up, right) && (grid[up + gravity][right] == 3 || grid[up + gravity][right] == 4)) {
			grid[up][right] = grid[up + gravity][right];
			grid[up + gravity][right] = 2;

		}
		if (isValid(gravity, up, right) && grid[up + gravity][right] != 0) {
			if (isValid(2, up, right) && isValid(3, up, right)) {
				if (grid[up + gravity][right - 1] == 0 && grid[up + gravity][right + 1] == 0) {
					if (rand.nextInt(2) == 1) {
						grid[up + gravity][right + 1] = grid[up][right];
						grid[up][right] = 0;
					} else {
						grid[up + gravity][right - 1] = grid[up][right];
						grid[up][right] = 0;
					}
				}

				else if (grid[up + gravity][right + 1] != 0 && grid[up + gravity][right - 1] == 0) {
					grid[up + gravity][right - 1] = grid[up][right];
					grid[up][right] = 0;
				} else if (grid[up + gravity][right + 1] == 0 && grid[up + gravity][right - 1] != 0) {
					grid[up + gravity][right + 1] = grid[up][right];
					grid[up][right] = 0;
				}
			}
		}
		if (isValid(2, up, right) && !(isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right - 1] == 0) {
				grid[up + gravity][right - 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}
		if (!isValid(2, up, right) && (isValid(3, up, right)) && isValid(gravity, up, right)) {
			if (grid[up + gravity][right + 1] == 0) {
				grid[up + gravity][right + 1] = grid[up][right];
				grid[up][right] = 0;
			}
		}

	}

	private boolean isValid(int grav, int up, int right) {
		if (grav == -1 && up - 1 >= 0) {
			return true;
		} else if (grav == 2 && right - 1 >= 0) {
			return true;
		} else if (grav == 3 && right + 1 < grid[up].length) {
			return true;
		} else if (grav == 1 && up + 1 < grid.length) {
			return true;
		}
		return false;
	}
	
	private boolean loop(int grav, int up, int right) {
		if (grav == -1 && grid[grid.length -1][right] == 0) {
			return true;
		} else if (grav == 2 && grid[up][grid.length -1] == 0) {
			return true;
		} else if (grav == 3 && grid[up][0] == 0) {
			return true;
		} else if (grav == 1 && grid[0][right] == 0) {
			return true;
		}
		return false;
	}
	private int loopty(int grav, int up, int right) {
		if (grav == -1 && grid[grid.length -1][right] == 0) {
			return (grid.length -1);
		} else if (grav == 2 && grid[up][grid[up].length -1] == 0) {
			return (grid[up].length -1);
		} else if (grav == 3 && grid[up][0] == 0) {
			return 0;
		} else if (grav == 1 && grid[0][right] == 0) {
			return 0;
		}
		return 1; 
	}

}
