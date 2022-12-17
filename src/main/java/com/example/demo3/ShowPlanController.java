package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowPlanController {

    @FXML
    private Text feedbackText;

    @FXML
    private TableColumn<?, ?> friNorm;

    @FXML
    private TableView<Session> friTable;

    @FXML
    private TableColumn<?, ?> friWarm;

    @FXML
    private TableColumn<?, ?> monNorm;

    @FXML
    private TableView<Session> monTable;

    @FXML
    private TableColumn<?, ?> monWarm;

    @FXML
    private Label pageNameText;

    @FXML
    private TableColumn<?, ?> saturNorm;

    @FXML
    private TableView<Session> saturTable;

    @FXML
    private TableColumn<?, ?> saturWarm;

    @FXML
    private TableColumn<?, ?> sunNormTable;

    @FXML
    private TableColumn<?, ?> sunWarmTable;

    @FXML
    private TableColumn<?, ?> sunWarmTable1;

    @FXML
    private TableView<Session> sundaySchedule;

    @FXML
    private TableColumn<?, ?> teusNorm;

    @FXML
    private TableView<Session> teusTable;

    @FXML
    private TableColumn<?, ?> teusWarm;

    @FXML
    private TableColumn<?, ?> thursNorm;

    @FXML
    private TableView<Session> thursTable;

    @FXML
    private TableColumn<?, ?> thursWarm;

    @FXML
    private TableColumn<?, ?> wednNorm;

    @FXML
    private TableView<Session> wednTable;

    @FXML
    private TableColumn<?, ?> wednWarm;

    Plan plan;

    Trainee curr;

    @FXML
    void homePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TraineeMainPage.fxml"));
        Stage stage = (Stage) sundaySchedule.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){
        try{
            pageNameText.setText(plan.getName());
            Member user = Account.getCurrentUser();
            if (user instanceof Trainee){
                curr= (Trainee) Account.getCurrentUser();
                plan = curr.getPlan();
                loadPlan();
            }
        } catch (Exception e){
            plan = new Plan();
        }
    }


    public void addSession(ObservableList<Session> sessionList, int day){
        ObservableList<Session> sessionCopy= FXCollections.observableArrayList();
        if (!sessionList.isEmpty())
            sessionCopy.add(sessionList.get(sessionList.size()-1));
        switch (day){
            case 0 -> {
                sundaySchedule.setItems(sessionCopy);
                sunWarmTable.setCellValueFactory(new PropertyValueFactory("warmupSession"));
                sunNormTable.setCellValueFactory(new PropertyValueFactory("normSession"));
            }
            case 1 -> {
                monTable.setItems(sessionCopy);
                monWarm.setCellValueFactory(new PropertyValueFactory("warmupSession"));
                monNorm.setCellValueFactory(new PropertyValueFactory("normSession"));
            }
            case 2 -> {
                teusTable.setItems(sessionCopy);
                teusNorm.setCellValueFactory(new PropertyValueFactory("warmupSession"));
                teusWarm.setCellValueFactory(new PropertyValueFactory("normSession"));
            }
            case 3 -> {
                wednTable.setItems(sessionCopy);
                wednWarm.setCellValueFactory(new PropertyValueFactory("warmupSession"));
                wednNorm.setCellValueFactory(new PropertyValueFactory("normSession"));
            }
            case 4 -> {
                thursTable.setItems(sessionCopy);
                thursWarm.setCellValueFactory(new PropertyValueFactory("warmupSession"));
                thursNorm.setCellValueFactory(new PropertyValueFactory("normSession"));
            }
            case 5 -> {
                friTable.setItems(sessionCopy);
                friWarm.setCellValueFactory(new PropertyValueFactory("warmupSession"));
                friNorm.setCellValueFactory(new PropertyValueFactory("normSession"));
            }
            case 6 -> {
                saturTable.setItems(sessionCopy);
                saturWarm.setCellValueFactory(new PropertyValueFactory("warmupSession"));
                saturNorm.setCellValueFactory(new PropertyValueFactory("normSession"));
            }
            default -> System.out.println("error");
        }
    }
    public void loadPlan(){
        ObservableList<Session> sessionsList= FXCollections.observableArrayList();
        for (int i=0;i<7;i++){
            sessionsList.add(plan.sessions[i]);
            if (plan.busyDays[i]==1)
                addSession(sessionsList,i);
            sessionsList.clear();
        }
    }

}
