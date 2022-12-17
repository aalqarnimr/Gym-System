package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class homePageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToPlanList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PlanList-view.fxml"));
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToProgress(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("showProgress-main.fxml")); // add the fxml file name there
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
