package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TraineeController {

    @FXML
    private Button addTraineeButton;

    @FXML
    private Button deleteTraineeButton;

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

}
