package letsDoThis;

public class item {
	
	//Attributes
	int room; 
	String name, type; 
	
	
	//Constructor
	public item(int numb, String call, String way) {
		room = numb;
		name = call; 
		type = way; 
	}
	
	//Methods


	public int getRoom() {
		return room;
	}


	public void setRoom(int room) {
		this.room = room;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
