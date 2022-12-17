package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        for (int i=0; i<APIComm.trainerList.size();i++) {
//            APIComm.trainerList.remove(i);
//        }
//        APIComm.WriteTrainerToFile(APIComm.trainerList);
//
//        for (int i=0; i<APIComm.traineeList.size();i++) {
//            APIComm.traineeList.remove(i);
//        }
//        APIComm.WriteTraineeToFile(APIComm.traineeList);

        APIComm.getInfo();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("trainerPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 600);
        stage.setTitle("GymApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        
    }
}