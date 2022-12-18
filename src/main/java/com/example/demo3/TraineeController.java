package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TraineeController {

    @FXML
    private Label label;

    @FXML
    private Button modifyProfile;

    public void toModifyProfile() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("traineePage.fxml"));
        Stage stage = (Stage) label.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toShowPlan() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("showPlan-view.fxml"));
        Stage stage = (Stage) label.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void backToWlc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("wlcPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void toWorkouts() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WorkoutsList.fxml"));
        Stage stage = (Stage) label.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toShowProgress() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("showProgress-main.fxml"));
        Stage stage = (Stage) label.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
