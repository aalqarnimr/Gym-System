package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class deletePageController implements Initializable {

    @FXML
    private ListView<Trainee> listView;
    @FXML
    private Label label3;
    Trainee[] traineesList=new Trainee[APIComm.trainerList.get(0).traineeList.size()];
    @FXML
    private Button mainPageButton;
    @FXML
    private Button refreshPageButton;
    @FXML
    private Button removeButton;


    String[] food ={"1","2","3"};
    Trainee curr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i=0; i< traineesList.length; i++){
            traineesList[i]=APIComm.trainerList.get(0).traineeList.get(i);
        }
        listView.getItems().addAll(traineesList);
    }
    @FXML
    public void remove()throws IOException{
        try {
            int selID = listView.getSelectionModel().getSelectedIndex();
            for (int i = 0; i < APIComm.trainerList.get(0).traineeList.size(); i++) {
                if (listView.getSelectionModel().getSelectedItems().get(0).getId() == APIComm.trainerList.get(0).traineeList.get(i).getId()) {
                    APIComm.trainerList.get(0).traineeList.remove(i);
                    label3.setText("Trainee was deleted successfully");

                }
            }
            listView.getItems().remove(selID);
        }
        catch (Exception e){
            label3.setText("Error, no trainee chosen to delete");
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

        Parent root = FXMLLoader.load(getClass().getResource("DeletePage.fxml"));
        Stage stage = (Stage) mainPageButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
