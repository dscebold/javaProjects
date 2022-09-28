package confour;

import javax.swing.JButton;

public class ButtonIndex {
	
	//Attributes
	
	
	private int row, column; 
	private JButton button; 
	
	//Constructor
	
	public ButtonIndex(int row, int column) {
		this.row = row;
		this.column = column; 
		button = new JButton(); 
	}
	
	//Methods

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}
	
	

}
