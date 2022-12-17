package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPageController implements Initializable {

    @FXML
    private ChoiceBox<Plan> PlansChoice;
    @FXML
    private ListView<Trainee> listView;
    @FXML
    private Label label2;
    Trainee[] traineesList=new Trainee[APIComm.traineeList.size()];
    @FXML
    private Button mainPageButton;
    @FXML
    private Button refreshPageButton;
    @FXML
    private Button confirmButton;
    Trainer curr;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        curr = (Trainer) Account.getCurrentUser();
        for (int i=0; i< traineesList.length; i++){
            if (APIComm.traineeList.get(i).assigned==false){
                traineesList[i]=APIComm.traineeList.get(i);
            }

        }
        listView.getItems().addAll(traineesList);
    }
    @FXML
    public void confirm()throws IOException{
        try {
            int selID = listView.getSelectionModel().getSelectedIndex();
            Plan selectedPlan = PlansChoice.getSelectionModel().getSelectedItem();

            if (selectedPlan==null)
                label2.setText("you must Choose a plan");
            else {

                for (int i = 0; i < APIComm.traineeList.size(); i++) {
                    if (listView.getSelectionModel().getSelectedItems().get(0).getId().equals(APIComm.traineeList.get(i).getId())) {
                        APIComm.traineeList.get(i).plan=selectedPlan;
                        curr.addTrainee(APIComm.traineeList.get(i));
                        APIComm.traineeList.get(i).assigned = true;
                        APIComm.WriteTrainerToFile(APIComm.trainerList);
                        APIComm.WriteTraineeToFile(APIComm.traineeList);
                        label2.setText("Trainee was added successfully");
                        System.out.println(APIComm.traineeList.toString());
                    }
                }
                listView.getItems().remove(selID);
            }
        }
        catch (Exception e){
            label2.setText("Error, no trainee chosen to add");
        }
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
    public void refreshPage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("infoPage.fxml"));
        Stage stage = (Stage) mainPageButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void loadPlans(){
        PlansChoice.getItems().clear();
        PlansChoice.getItems().addAll(APIComm.savedPlans);
    }

}
