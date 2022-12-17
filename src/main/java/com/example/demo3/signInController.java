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
    @FXML
    private Button signInButton;
    @FXML
    private Button backButton;

    public static String pass;
    public static String name;


    @FXML
    void backToWlc() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("wlcPage.fxml"));
        Stage stage = (Stage) backButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void passToggle() {
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
        String s = messageLabel.getText();
        if (((name+pass+s).endsWith("trainer"))){
            for (int i = 0; i<APIComm.trainerList.size();i++){
                if((name+pass+"trainer").equals(APIComm.trainerList.get(i).trainerID)){
                    int x = i;
                    Trainer x1 = APIComm.trainerList.get(i);
                    Account.setCurrentUser(x1);
                    Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
                    Stage stage = (Stage) signInButton.getScene().getWindow();
                    Scene scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

            }
        }
        else if (((name+pass+s).endsWith("trainee"))){
            for (int i = 0; i<APIComm.traineeList.size();i++){
                if((name+pass+"trainee").equals(APIComm.traineeList.get(i).traineeID)){
                    int x = i;
                    Trainee trainee = APIComm.traineeList.get(i);
                    Account.setCurrentUser(trainee);
                    Parent root = FXMLLoader.load(getClass().getResource("TraineeMainPage.fxml"));
                    Stage stage = (Stage) signInButton.getScene().getWindow();
                    Scene scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

            }
        }



    }
    public static void main(String[] args) throws IOException, InterruptedException {

    }
}
