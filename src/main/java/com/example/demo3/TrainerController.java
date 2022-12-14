package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TrainerController {

    @FXML
    private ChoiceBox<Plan> PlansChoice;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private FXMLLoader fxmlLoader;
    @FXML
    private Parent root;
    @FXML
    private Button addTraineeButton;
    @FXML
    private Button deleteTraineeButton;
    @FXML
    private Button confirmButton;
    @FXML
    private Button modifyAccountButton;
    @FXML
    private Button addPlanButton;
    @FXML
    private Button modifyPlanButton;
    @FXML
    private Button mainPageButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextField textField1;
    static boolean isEdit;

    String traineeId;
    int x=0;
    Trainer curr;
    @FXML
    private Button editTrainerButton;



    public void initialize(){
        editTrainerButton.setVisible(false);
        isEdit=false;
        curr = (Trainer) Account.getCurrentUser();

//        PlansChoice.setValue("Choose a plan");
        if (curr.trainerID.equals("adminadmintrainer")){
            editTrainerButton.setVisible(true);
        }
    }

    @FXML
    public void toInfoPage() throws IOException {
        if (APIComm.trainerList.size()==0)
            APIComm.trainerList.add(new Trainer("null"));
        else {
            APIComm.trainerList.add(new Trainer("null"));

        }

        Parent root = FXMLLoader.load(getClass().getResource("infoPage.fxml"));
        Stage stage = (Stage) addTraineeButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void toDeletePage() throws IOException {
        if (APIComm.trainerList.size()==0)
            APIComm.trainerList.add(new Trainer("null"));
        else {
            APIComm.trainerList.add(new Trainer("null"));
        }

        Parent root = FXMLLoader.load(getClass().getResource("DeletePage.fxml"));
        Stage stage = (Stage) deleteTraineeButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toMainPage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage stage = (Stage) mainPageButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void backToWlc(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("wlcPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void goToAddPlan() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AddPlan-view.fxml"));
        Stage stage = (Stage) addPlanButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToPlanList() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("PlanList-view.fxml"));
        Stage stage = (Stage) modifyPlanButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToModifyAccount() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("trainerPage.fxml"));
        Stage stage = (Stage) modifyPlanButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showTrainers(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("viewMemebers.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
