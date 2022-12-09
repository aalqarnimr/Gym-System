package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class wlcPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void toSigninScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("wlcPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toSignupScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("wlcPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void signIn(ActionEvent e) {
        System.out.println("sign in");

    }
    public void signUp(ActionEvent e) {
        System.out.println("sign up");


    }
}
