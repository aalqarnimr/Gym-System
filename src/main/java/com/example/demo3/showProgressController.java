package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class showProgressController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTargetedWeight(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("showProgress-targetedWeight.fxml"));
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToRepetitions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("showProgress-repetitions.fxml")); // add the fxml file name there
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToVolumeProgress(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("showProgress-volumeProgress.fxml")); // add the fxml file name there
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
