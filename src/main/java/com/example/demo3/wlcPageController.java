package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class wlcPageController {
    @FXML
    private Button signInB;
    @FXML
    private Button signUpB;

    public void toSigninScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
        Stage stage = (Stage) signInB.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toSignupScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Stage stage = (Stage) signUpB.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
