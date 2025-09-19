package sudoku.model;

public class SudokuSolver {
	//SudokuCreator game;
	public static int[][] solve(int[][] grid){
		
		outerloop:
		for(int row =0;row<9;row++) {
			for (int col = 0;col<9;col++) {
				if(grid[row][col]==0) {
					for(int i =1;i<10;i++) {
						if(checkrow(row,i,grid) && checkcol(col,i,grid) && checkbox(row,col,grid,i) && i !=10) {
							grid[row][col] = i;
							if(solve(grid) != null) {
								break outerloop;
							}
						}
					}
					return null;
				}
				
			}
		}
		return grid;
	}
	
	
	private static boolean checkrow(int row, int number, int[][] index) {
		
		boolean status = true;
		for(int i=0; i<index[row].length;i++) {
			if(index[row][i] == number) {
				status = false;
				break;
			}
		}
		
		return status;
		
		
	}
	
	private static boolean checkcol(int col, int number, int[][] index) {
		boolean status = true;
		for(int i=0; i<index.length;i++) {
			if(index[i][col] == number) {
				status = false;
				break;
			}
		}
		
		return status;
		
	}
	
	private static boolean checkbox(int row, int col, int[][] index, int number) {
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
	private static int[] belongs(int row, int col) {
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
}
