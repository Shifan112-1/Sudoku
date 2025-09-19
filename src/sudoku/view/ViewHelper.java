package sudoku.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sudoku.controller.MainController;

public class ViewHelper {

    private TextField[][] places = new TextField[9][9];

    private TextField[][] getMatrix(int[][] board1) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                places[row][col] = new TextField();
                places[row][col].setPrefSize(50, 50);

                if (board1[row][col] != 0) {
                    places[row][col].setText(String.valueOf(board1[row][col]));
                    places[row][col].setEditable(false);
                } else {
                    places[row][col].setText("");
                    places[row][col].setEditable(true);
                }
            }
        }
        return places;
    }

    public VBox getGrid(int[][] board1) {
        TextField[][] matrix = this.getMatrix(board1);

        GridPane board = new GridPane(); // fresh grid each time
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.add(matrix[row][col], col, row); // col first, row second
            }
        }
        board.setAlignment(Pos.CENTER);

        Button button = new Button("End");
        button.setOnAction(event -> {MainController.Solver(board1);});
        VBox layout = new VBox(10); // 10 px spacing
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(board, button);

        return layout;
    }
}

