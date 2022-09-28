package confour;

public class piece {
	
	
	//Attributes
	
	protected String type, win; 
	



	protected int value; 
	
	
	
	//Constructor
	
	public piece() {
		value = 0; 
		type = "   |";
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getValue() {
		return value;
	}



	public void setValue(int value) {
		this.value = value;
	}
	
	public String getWin() {
		return win;
	}



	public void setWin(String win) {
		this.win = win;
	}
	
	
	
	//Methods

}
