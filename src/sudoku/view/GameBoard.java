package sudoku.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sudoku.controller.MainController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import sudoku.controller.*;


public class GameBoard extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, Color.LIGHTGREY);
        
        Button button = new Button("START");
        Button button1 = new Button("Settings");
        Button button2 = new Button("Music");
        Button button3 = new Button("Mode");
        VBox box = new VBox(10);
        box.getChildren().addAll(button,button1,button2,button3);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(0,0,100,0));
        root.setCenter(box);
        
        button.setOnAction(event -> {
            primaryStage.setScene(MainController.Starter());
            primaryStage.setTitle("SUDOKU SCORE:");});

        
        primaryStage.setWidth(550);
        primaryStage.setHeight(550);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Welcome to Sudoku");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}