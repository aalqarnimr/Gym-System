package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class showProgressController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    LineChart<?, ?> chart;
    @FXML
    private ListView<Workout> workList;
   // @FXML
   Label workoutLabel;
    public void switchToHomePage(ActionEvent event) throws IOException {
        this.root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        this.stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void showDetails() {

    }
    public void doubleClick(MouseEvent click) {
        if (click.getClickCount() == 2) {
            //Use ListView's getSelected Item
            Workout currentItemSelected = workList.getSelectionModel().getSelectedItem();
            this.workoutLabel.setText(currentItemSelected.getName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        workList.getItems().addAll(APIComm.workouts);

        XYChart.Series targetedWeight = new XYChart.Series();
        XYChart.Series repetitions = new XYChart.Series();
        XYChart.Series volumeProgress = new XYChart.Series();

        for (String s : Arrays.asList("U", "M", "T", "W", "R", "F", "S")) {
            targetedWeight.getData().add(new XYChart.Data<>(s, Math.random() * 10));
        }
        for (String s : Arrays.asList("U", "M", "T", "W", "R", "F", "S")) {
            repetitions.getData().add(new XYChart.Data<>(s, (int) (Math.random() * 10)));
        }
        for (String s : Arrays.asList("U", "M", "T", "W", "R", "F", "S")) {
            volumeProgress.getData().add(new XYChart.Data<>(s, Math.random() * 10));
        }

        this.chart.getData().add(targetedWeight);
        this.chart.getData().add(repetitions);
        this.chart.getData().add(volumeProgress);


    }
}
