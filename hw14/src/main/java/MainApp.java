package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main/java/view/View.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("DateView");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
