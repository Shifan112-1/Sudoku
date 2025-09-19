package sudoku.view;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;

public class BoxView extends Application {
	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		GridPane board = new GridPane();
		board.setAlignment(Pos.CENTER);
	
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				TextField box = new TextField();
				box.setPrefSize(50,50);
				board.add(box, i, j);
			}
		}
		Scene scene = new Scene(board,500,500,Color.TRANSPARENT);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Sudoku");
		stage.show();
	}
}