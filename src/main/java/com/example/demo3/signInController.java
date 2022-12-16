package com.example.demo3;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class signInController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label messageLabel;
    @FXML
    private TextField usernameText;
    @FXML
    private TextField passTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ToggleButton passToggle;

    public static String pass;
    public static String name;

    @FXML
    void backToWlc(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("wlcPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void passToggle(ActionEvent event) {
        if (checkBox.isSelected()){
            passTextField.setText(passwordField.getText());
            passTextField.setVisible(true);
            passwordField.setVisible(false);
            return;
        }
        passwordField.setText((passTextField.getText()));
        passwordField.setVisible(true);
        passTextField.setVisible(false);
    }


    @FXML
    void signInMessage(ActionEvent event) throws IOException, InterruptedException {
        if (checkBox.isSelected()){
            pass = passTextField.getText();
        }else {
            pass = passwordField.getText();
        }
        name = usernameText.getText();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://us-central1-swe206-221.cloudfunctions.net/app/SignIn?teamKey=99345103&username="+name+"&password="+pass))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        messageLabel.setText(response.body());

    }
    public static void main(String[] args) throws IOException, InterruptedException {

    }
}
