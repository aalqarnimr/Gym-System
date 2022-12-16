package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TrainerController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private FXMLLoader fxmlLoader;
    @FXML
    private Parent root;
    @FXML
    private Button addTraineeButton;
    @FXML
    private Button deleteTraineeButton;
    @FXML
    private Button confirmButton;
    @FXML
    private Button mainPageButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextField textField1;

    int traineeId;
    int x=0;
    Trainer trainer=new Trainer();




    @FXML
    public void toInfoPage() throws IOException {
        if (APIComm.trainerList.size()==0)
            APIComm.trainerList.add(new Trainer(0));
        else {
            APIComm.trainerList.add(new Trainer(1));

        }

        Parent root = FXMLLoader.load(getClass().getResource("infoPage.fxml"));
        Stage stage = (Stage) addTraineeButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void toDeletePage() throws IOException {
        if (APIComm.trainerList.size()==0)
            APIComm.trainerList.add(new Trainer(0));
        else {
            APIComm.trainerList.add(new Trainer(1));
        }

        Parent root = FXMLLoader.load(getClass().getResource("DeletePage.fxml"));
        Stage stage = (Stage) deleteTraineeButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toMainPage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage stage = (Stage) mainPageButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void confirm(){
        boolean checker;
        try {
            traineeId=Integer.parseInt(textField1.getText());
             checker=APIComm.trainerList.get(0).checkTrainee(traineeId);

            if (checker){
                label2.setText("Error, trainee already added");
            }
            else {
                Trainee trainee=new Trainee(traineeId);
                trainee.setUserName(APIComm.generateUserName());
                trainee.setPassWord(APIComm.generatePassword());
                APIComm.trainerList.get(0).addTrainee(trainee);
                label2.setText("Trainee has been added successfully");

            }


        }
        catch (Exception e){
            System.out.println(e);
            label2.setText("Wrong ID enterd");
        }
    }



}
