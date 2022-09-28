package confour;

public class Grid {
	
	private String[][]board;
	private int[] top; 
	
	public Grid(int rows, int cols) {
		board = new String[rows][cols]; 
		top = new int[cols]; 
		setGrid();
	}
	
	private void setGrid() {
		for(int i = 0; i < board.length; i++) {
			for(int q = 0; q < board[i].length; q++) {
				board[i][q] = " "; 
			}
		}
		for(int i = 0; i < board[0].length; i++) {
			top[i] = (i + 1); 
		}
	}
	
	public void printGrid() {
		for(int i = 0; i < top.length; i++) {
			if(i == 0) {
				System.out.print(top[i]);
			}
			else if(i < 9) {
				System.out.print("   " + top[i]);
			}
			else {
				System.out.print("  " + top[i]);
			}
		}
		System.out.println();
		for(int i = 0; i < board.length; i++) {
			for(int q = 0; q < board[i].length; q++) {
				System.out.print(board[i][q]  + " | ");
			}
			System.out.println();
		}
	}
	

}
