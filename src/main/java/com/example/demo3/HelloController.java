package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloController {
    private Plan plan;
    @FXML
    private Button addButton;

    @FXML
    private StackPane addPane1;

    @FXML
    private DialogPane dialog;

    @FXML
    private ChoiceBox<String> choiceDay;

    @FXML
    private RadioButton radioNorm;

    @FXML
    private RadioButton radioWarm;


    @FXML
    private ListView<?> workList;

    public void initialize(){
        Trainer t= (Trainer) Account.getCurrentUser();
        plan = t.createPlan();
    }

    public void showSessionPane() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Stage stage = (Stage) addButton.getScene().getWindow();
        Stage pStage = new Stage();
        Pane sessionDialogBox = fxmlLoader.load(getClass().getResource("SessionEditor.fxml"));

        Dialog<ButtonType> dialog1 = new Dialog<>();
        dialog1.setDialogPane((DialogPane) sessionDialogBox);
        Optional<ButtonType> clickedButton = dialog1.showAndWait();
        if (clickedButton.get()==ButtonType.OK)
            System.out.println();
    }

}
