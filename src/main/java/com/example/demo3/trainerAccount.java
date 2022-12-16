package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class trainerAccount {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button cancelButton;

    @FXML
    private Button changePicButton;

    @FXML
    private Label heightLabel;

    @FXML
    private TextField heightTextField;

    @FXML
    private ImageView imageView;

    @FXML
    private Button saveButton;

    @FXML
    private Label specialtyLabel;

    @FXML
    private TextField specialtyTextField;

    @FXML
    private Pane traineePane;

    @FXML
    private Label weightLabel;

    @FXML
    private TextField weightTextField;

    @FXML
    void saveChanges(ActionEvent event) {
        String heightF = heightTextField.getText();
        String weightF = weightTextField.getText();
        String specialty = specialtyTextField.getText();
        Image imageF = imageView.getImage();

        System.out.println(heightF);
        System.out.println(weightF);
        System.out.println(specialty);
        System.out.println(imageF);

    }

    @FXML
    void setChangePicButton(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
        File file = fc.showOpenDialog(stage);
        Image image = new Image(String.valueOf(file));
        imageView.setImage(image);
    }


}
