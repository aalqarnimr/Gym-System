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

public class WorkoutsListController {
    static Workout selectedWorkout;
    @FXML
    private Button showWorkoutButton;

    @FXML
    private Text feedText;

    @FXML
    private ListView<Workout> plansListView;

    public void initialize(){
        selectedWorkout=null;
        plansListView.getItems().addAll(APIComm.avaliableWorkouts);
    }
    public void setPlanToEdit() throws IOException {
        selectedWorkout= (Workout) plansListView.getSelectionModel().getSelectedItem();
        if (selectedWorkout==null)
            feedText.setText("error: user didn't choose Workout");
        else {
            Parent root = FXMLLoader.load(getClass().getResource("showWorkouts.fxml"));
            Stage stage = (Stage) plansListView.getScene().getWindow();
            Scene scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
    public void homePage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TraineeMainPage.fxml"));
        Stage stage = (Stage) feedText.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
