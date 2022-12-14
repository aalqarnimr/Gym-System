package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class signUp implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ChoiceBox<String> personType;
    @FXML
    private Button backButton;
    private String[] personList = {"trainer", "trainee"};
    @FXML
    private TextField usernametext;
    @FXML
    private TextField passwordField;
    public static String name, pass, type;

    public void backToWlc() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("wlcPage.fxml"));
        Stage stage = (Stage) backButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void signUpMessage() throws IOException, InterruptedException {
        name = usernametext.getText();
        pass = passwordField.getText();
        type = personType.getValue();

        String id = name+pass+type;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://us-central1-swe206-221.cloudfunctions.net/app/SignUp?teamKey=99345103"))
                .header("content-type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\n\n    \"username\":\""+name+"\",\n\n    \"password\":\""+pass+"\",\n\n    \"type\":\""+type+"\"\n\n}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.toString());
        if (personType.getValue().equals("trainer")) {
            APIComm.trainerList.add(new Trainer(name + pass + type));
            APIComm.WriteTrainerToFile(APIComm.trainerList);
        }
        else {
            APIComm.traineeList.add(new Trainee(name + pass + type));
            APIComm.WriteTraineeToFile(APIComm.traineeList);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        personType.getItems().addAll(personList);
        personType.setValue("trainee");
        personType.setOnAction(this::gType);
    }
    public void gType(ActionEvent event){
        String personTypeValue = personType.getValue();
    }

    public static void main(String[] args) {

    }


}

