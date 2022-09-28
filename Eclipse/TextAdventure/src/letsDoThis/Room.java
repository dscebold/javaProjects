package letsDoThis;

public class Room {
	
	//Attributes
	
	private boolean up, down, left, right, entered, searched;
	private String name; 
	
	
	//Constructor
	
	public Room(boolean north, boolean south, boolean west, boolean east, String name) {
		up = north;
		down = south;
		left = west;
		right = east;
		this.name = name;
		entered = false; 
		searched = false;
	}
	
	//Methods


	public boolean isUp() {
		return up;
	}


	public void setUp(boolean up) {
		this.up = up;
	}


	public boolean isDown() {
		return down;
	}


	public void setDown(boolean down) {
		this.down = down;
	}


	public boolean isLeft() {
		return left;
	}


	public void setLeft(boolean left) {
		this.left = left;
	}


	public boolean isRight() {
		return right;
	}


	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isEntered() {
		return entered;
	}

	public void setEntered(boolean entered) {
		this.entered = entered;
	}

	public boolean isSearched() {
		return searched;
	}

	public void setSearched(boolean searched) {
		this.searched = searched;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
