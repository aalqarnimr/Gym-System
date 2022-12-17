package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
    private MediaView mediaView;

    @FXML
    Button homeButton, backButton, nextButton, playButton, stopButton, restartButton, increment10Seconds, decrement10Seconds;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("C:\\Users\\user\\Desktop\\Zoom.mp4");
            media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);


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

        root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
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
