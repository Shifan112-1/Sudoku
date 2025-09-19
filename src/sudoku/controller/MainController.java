package sudoku.controller;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import sudoku.model.SudokuCreator;
import sudoku.model.SudokuSolver;
import sudoku.view.ViewHelper;

public class MainController {
	
	public static Scene Starter() {
		SudokuCreator board = new SudokuCreator();
		ViewHelper obj = new ViewHelper();
		//obj.getGrid().setAlignment(Pos.CENTER);
		Scene scene = new Scene(obj.getGrid(board.createGrid()),500,500);
		return scene;
	}
	
	public static Scene Solver(int[][] index) {
		int[][] solved = SudokuSolver.solve(index);
		
	}

}
