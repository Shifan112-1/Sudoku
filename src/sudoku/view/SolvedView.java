package sudoku.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sudoku.controller.MainController;

public class SolvedView {

	public class ViewHelper {

	    private TextField[][] places = new TextField[9][9];

	    private TextField[][] getMatrix(int[][] board1) {
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                places[row][col] = new TextField();
	                places[row][col].setPrefSize(50, 50);
	                    places[row][col].setText(String.valueOf(board1[row][col]));
	                    places[row][col].setEditable(false);
	            }
	        }
	        return places;
	    }

	    public VBox getGrid(int[][] board1) {
	        TextField[][] matrix = this.getMatrix(board1);

	        GridPane board = new GridPane(); 
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                board.add(matrix[row][col], col, row); 
	            }
	        }
	        board.setAlignment(Pos.CENTER);
	        VBox layout = new VBox(10); 
	        layout.setAlignment(Pos.CENTER);
	        layout.getChildren().addAll(board);

	        return layout;
	    }
	}
}
