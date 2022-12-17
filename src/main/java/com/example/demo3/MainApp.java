package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        APIComm.getInfo();

        //This code for testing.
        Parent root = FXMLLoader.load(getClass().getResource("workoutPage.fxml"));
        Scene scene = new Scene(root);

        //Uncomment these lines when the testing process ends.
        //FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("wlcPage.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 360, 600);
        //---

        stage.setTitle("GymApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        
    }
}