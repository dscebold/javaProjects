
public class BasicMatrixNotesRunner {

	public static void main(String[] args) {

		// A matrix is just a collection of collections

		int[][] grid = new int[10][10];
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				System.out.print(grid[row][col] + " ");
			}
			System.out.println();
		}
			
		//int[][][][][][] thing = new int[10][10][10][10][10][10];\\
		
		for(int row = 0; row< grid.length; row++) {
			for(int col = 0; col< grid[row].length; col++) {
				if(row % 2 == 0 && col % 2 == 0) {
					grid[row][col] = 1; 
				}
				else if(row % 2 == 1 && col % 2 == 1) {
					grid[row][col] =  1; 
				}
			}
		}
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				System.out.print(grid[row][col] + " ");
			}
			System.out.println();
		}
		
		
		String[][] words = new String[3][3];
		
		String temp = "";
		for(int i = 0; i < words.length; i++) {
			for(int q = 0; q < words[i].length; q++) {
				temp += (words[i][q] + " ");
			}
			temp += "\n";
		}
		
		System.out.println(temp);

	}

}
