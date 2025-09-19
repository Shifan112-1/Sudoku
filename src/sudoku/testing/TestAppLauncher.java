package sudoku.testing;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestAppLauncher extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Sudoku Test");
        stage.setScene(TestController.startScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
