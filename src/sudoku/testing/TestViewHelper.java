package sudoku.testing;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TestViewHelper {

    private final TextField[][] cells = new TextField[9][9];

    private void initMatrix(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                TextField tf = new TextField();
                tf.setPrefSize(50, 50);
                tf.setAlignment(Pos.CENTER);
                if (board[r][c] != 0) {
                    tf.setText(String.valueOf(board[r][c]));
                    tf.setEditable(false);
                }
                cells[r][c] = tf;
            }
        }
    }

    private int[][] readGrid() {
        int[][] g = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                String t = cells[r][c].getText();
                if (t == null || t.isBlank()) {
                    g[r][c] = 0;
                } else {
                    try {
                        g[r][c] = Integer.parseInt(t.trim());
                    } catch (NumberFormatException e) {
                        g[r][c] = 0; // be forgiving for quick tests
                    }
                }
            }
        }
        return g;
    }

    public VBox getGrid(int[][] board) {
        initMatrix(board);

        GridPane grid = new GridPane();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                grid.add(cells[r][c], c, r); // column first, then row
            }
        }
        grid.setAlignment(Pos.CENTER);

        Button solveBtn = new Button("Solve");
        solveBtn.setOnAction(e -> {
            int[][] current = readGrid();
            Scene solvedScene = TestController.solveScene(current);
            if (solvedScene != null) {
                // swap root to the solved view without touching the Stage
                solveBtn.getScene().setRoot((Parent) solvedScene.getRoot());
            }
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(grid, solveBtn);
        return layout;
    }
}
