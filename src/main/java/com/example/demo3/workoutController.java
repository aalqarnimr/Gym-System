package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class workoutController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label repetitions;

    @FXML
    private TextField repetitionsUpdate;

    @FXML
    private Label sets;

    @FXML
    private TextField setsUpdate;

    @FXML
    private Label steps;

    @FXML
    private Label targetedMuscles;

    @FXML
    private TextField weightUsedUpdate;

    @FXML
    private Label workoutName;


    @FXML
    private MediaView mediaView;

    @FXML
    Button homeButton, backButton, nextButton, playButton, stopButton, restartButton, increment10Seconds, decrement10Seconds;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    Workout selectedWorkout;

    @FXML
    private WebView youtubeVid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedWorkout = WorkoutsListController.selectedWorkout;
        youtubeVid.getEngine().load(selectedWorkout.youtubeLink);
        workoutName.setText(selectedWorkout.getName());
        targetedMuscles.setText(selectedWorkout.targetedMuscles);
        sets.setText(String.valueOf(selectedWorkout.sets));
        repetitions.setText(String.valueOf(selectedWorkout.goalRepetitions));
    }
    //Video Buttons
    public void playMedia() {
        mediaPlayer.play();
    }
    public void stopMedia() {
        mediaPlayer.pause();
    }
    public void restartMedia() {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
        }
    }
    public void increment10Seconds() {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(mediaPlayer.getCurrentTime().toSeconds() + 10.0));
        }
    }
    public void decrement10Seconds() {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(mediaPlayer.getCurrentTime().toSeconds() - 10.0));
        }
    }

    //Upper buttons
    public void switchToHomePage(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("TraineeMainPage.fxml"));
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void nextWorkout() {

    }
    public void previousWorkout() {

    }
}