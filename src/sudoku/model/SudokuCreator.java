package sudoku.model;


import java.util.Random;


public class SudokuCreator {
	private int[][] grid;
	
	public int[][] createGrid() {
		grid = new int[9][9];
		Random rand = new Random();
		int row =-1;
		int col =-1;
		int number =-1;
		for(int i =0; i<=20;i++) {
			boolean status = true;
			while(status) {
				row = rand.nextInt(9);
				col = rand.nextInt(9);
				status = used(row, col, grid);
			}
			do {
				number = rand.nextInt(9) + 1;
			}while(!checkrow(row, number, grid) || !checkcol(col, number, grid) || !checkbox(row, col, grid, number));
			
			grid[row][col] = number;
		}
		
	return grid;
	}
	
	private boolean checkrow(int row, int number, int[][] index) {
		
		boolean status = true;
		for(int i=0; i<index[row].length;i++) {
			if(index[row][i] == number) {
				status = false;
				break;
			}
		}
		
		return status;
		
		
	}
	
	private boolean checkcol(int col, int number, int[][] index) {
		boolean status = true;
		for(int i=0; i<index.length;i++) {
			if(index[i][col] == number) {
				status = false;
				break;
			}
		}
		
		return status;
		
	}
	
	private boolean checkbox(int row, int col, int[][] index, int number) {
		boolean status = true;
		int[] place = belongs(row, col);
		outerloop:
		for(int i =place[0]-1; i<=place[0]+1;i++) {
			for(int j = place[1]-1; j<=place[1]+1;j++) {
				if(index[i][j] == number) {
					status = false;
					break outerloop;
				}
			}
		}
		return status;
		
	}
	
	
	
	private int[] belongs(int row, int col) {
	    int place1 = -1;
	    int place2 = -1;

	    outerloop:
	    for (int i = 1; i < 9; i += 3) {
	        for (int j = 1; j < 9; j += 3) {
	            for (int r = i - 1; r <= i + 1; r++) {  
	                for (int c = j - 1; c <= j + 1; c++) { 
	                    if (r == row && c == col) {
	                        place1 = i;
	                        place2 = j;
	                        break outerloop;
	                    }
	                }
	            }
	        }
	    }

	    int[] values = {place1,place2};
	    return values;
	}
	
	
	private boolean used(int row, int col, int[][] index) {
		boolean status = true;
		if(index[row][col] == 0) {
			status = false;
		}
		return status;
	}

}
