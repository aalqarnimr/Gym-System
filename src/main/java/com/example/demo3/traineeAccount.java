package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
import java.io.IOException;

public class traineeAccount {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Pane traineePane;
    @FXML
    private Button cancelButton;
    @FXML
    private Button changePicButton;
    @FXML
    private Button saveButton;
    @FXML
    private Label heightLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label hmessageLabel,wmessageLabel;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField weightTextField;

    double height, weight;
    String imagePath;
    Image sImage;



    @FXML
    void saveChanges(){
        try{
            height = Double.parseDouble(heightTextField.getText());
            Account.currentMember.height=height;
            System.out.println(height);
            hmessageLabel.setText("height recorded");
        }
        catch(NumberFormatException e){
            hmessageLabel.setText("Height can't be text or empty");
        }
        try{
            weight = Double.parseDouble(weightTextField.getText());
            Account.currentMember.weight = weight;
            System.out.println(weight);
            wmessageLabel.setText("Weight recorded");
        }
        catch(NumberFormatException e){
            wmessageLabel.setText("Weight can't be text or empty");
        }

        imagePath = imageView.getImage().getUrl();
        System.out.println(imagePath);
    }

    @FXML
    void setChangePicButton(){
        try{
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
                                        new FileChooser.ExtensionFilter("PNG", "*.png"));
        File file = fc.showOpenDialog(stage);
        Image image = new Image(String.valueOf(file));
        imageView.setImage(image);}
        catch(IllegalArgumentException e){
            System.out.println("no image selected");
        }
    }

    public void toMainPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TraineeMainPage.fxml"));
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
