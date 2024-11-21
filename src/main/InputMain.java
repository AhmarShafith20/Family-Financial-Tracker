package main;

//author Shifan
import javafx.application.Application;
import javafx.stage.Stage;


public class InputMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        InputViewBuilder view = new InputViewBuilder(primaryStage);
        InputController controller = new InputController(view);
        primaryStage.setTitle("Family Finance Tracker");
        primaryStage.show();
    }
}