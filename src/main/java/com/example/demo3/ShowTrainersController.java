package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;

public class ShowTrainersController {
    static Trainer selectedTrainer;
    @FXML
    private Button showWorkoutButton;

    @FXML
    private Text feedText;

    @FXML
    private ListView<Trainer> plansListView;

    public void initialize(){
        selectedTrainer=null;
        plansListView.getItems().addAll(APIComm.trainerList);
    }
    public void setPlanToEdit() throws IOException {
        selectedTrainer= (Trainer) plansListView.getSelectionModel().getSelectedItem();
        if (selectedTrainer==null)
            feedText.setText("error: you didn't choose Trainer");
        if (selectedTrainer.trainerID.equals("adminadmintrainer"))
            feedText.setText("error: you cant remove yourself");
        else {
            APIComm.trainerList.remove(selectedTrainer);
            feedText.setText("trainer deleted successfully");
            APIComm.WriteTrainerToFile(APIComm.trainerList);
            plansListView.getItems().clear();
            plansListView.getItems().addAll(APIComm.trainerList);
        }

    }
    public void homePage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage stage = (Stage) feedText.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void deleteAllTrainers(){
        APIComm.trainerList.clear();
        feedText.setText("trainers deleted successfully");
        APIComm.trainerList.add(new Trainer("adminadmintrainer"));
        APIComm.WriteTrainerToFile(APIComm.trainerList);
        plansListView.getItems().clear();
        plansListView.getItems().addAll(APIComm.trainerList);
    }
}
