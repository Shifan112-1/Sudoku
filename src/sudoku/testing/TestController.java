package sudoku.testing;

import javafx.scene.Scene;
import sudoku.model.SudokuCreator;
import sudoku.model.SudokuSolver;

public class TestController {

    // Build initial scene from a freshly created puzzle (your SudokuCreator)
    public static Scene startScene() {
        SudokuCreator creator = new SudokuCreator();
        TestViewHelper view = new TestViewHelper();
        return new Scene(view.getGrid(creator.createGrid()), 500, 550);
    }

    // Build a scene from a solved grid (uses your SudokuSolver)
    public static Scene solveScene(int[][] grid) {
        // If your solve(...) returns int[][]:
        int[][] solved = SudokuSolver.solve(grid);

        // If your solve(...) solves in-place and returns boolean instead, use this:
        // if (!SudokuSolver.solve(grid)) return null;
        // int[][] solved = grid;

        TestViewHelper view = new TestViewHelper();
        return new Scene(view.getGrid(solved), 500, 550);
    }
}
