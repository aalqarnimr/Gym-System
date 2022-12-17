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

public class trainerAccount {
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
    private Label specialtyLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label hmessageLabel,wmessageLabel, imessageLabel;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField specialtyTextField;

    double height, weight;
    String specialty, imagePath;
    Image sImage;


    public void initialize(){

        heightTextField.setText(""+Account.currentMember.getHeight());
        weightTextField.setText(""+Account.currentMember.getWeight());
        if (Account.currentMember instanceof Trainer){
            specialtyTextField.setText(""+((Trainer) Account.currentMember).getSpecialty());
        }


//        PlansChoice.setValue("Choose a plan");
    }
    @FXML
    void saveChanges() {
        try{

            height = Double.parseDouble(heightTextField.getText());
            Account.currentMember.setHeight(height);
            APIComm.WriteTrainerToFile(APIComm.trainerList);
            System.out.println(height);
            hmessageLabel.setText("height recorded");
        }
         catch(NumberFormatException e){
             hmessageLabel.setText("Height can't be text or empty");
        }
        try{
            weight = Double.parseDouble(weightTextField.getText());
            Account.currentMember.setWeight(weight);
            APIComm.WriteTrainerToFile(APIComm.trainerList);
            System.out.println(weight);
            wmessageLabel.setText("Weight recorded");
        }
         catch(NumberFormatException e){
             wmessageLabel.setText("Weight can't be text or empty");
        }


        specialty = specialtyTextField.getText();
        if (Account.currentMember instanceof Trainer){
            ((Trainer) Account.currentMember).setSpecialty(specialty);
            APIComm.WriteTrainerToFile(APIComm.trainerList);

        }
        try{

            imagePath = imageView.getImage().getUrl();
            Account.currentMember.setImgPath(imagePath);
            APIComm.WriteTrainerToFile(APIComm.trainerList);
            System.out.println(imagePath);
        }
        catch(Exception e){
            imessageLabel.setText("Wrong path");
        }


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

    public void toMainPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
