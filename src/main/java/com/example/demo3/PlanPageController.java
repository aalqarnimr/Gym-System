package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.util.Optional;

public class PlanPageController {
    private Plan plan;


    @FXML
    private TableColumn<?, ?> friNorm;

    @FXML
    private TableView<Session> friTable;

    @FXML
    private TableColumn<?, ?> friWarm;

    @FXML
    private TableColumn<?, ?> saturNorm;

    @FXML
    private TableView<Session> saturTable;

    @FXML
    private TableColumn<?, ?> saturWarm;

    @FXML
    private TableColumn<?, ?> thursNorm;

    @FXML
    private TableView<Session> thursTable;

    @FXML
    private TableColumn<?, ?> thursWarm;
    @FXML
    private TableView<Session> sundaySchedule;

    @FXML
    private TableColumn<?, ?> sunNormTable;

    @FXML
    private TableColumn<?, ?> sunWarmTable;
    @FXML
    private TableColumn<?, ?> teusNorm;

    @FXML
    private TableView<Session> teusTable;

    @FXML
    private TableColumn<?, ?> teusWarm;

    @FXML
    private TableColumn<?, ?> wednNorm;

    @FXML
    private TableView<Session> wednTable;

    @FXML
    private TableColumn<?, ?> wednWarm;

    @FXML
    private TableColumn<?, ?> monNorm;

    @FXML
    private TableView<Session> monTable;

    @FXML
    private TableColumn<?, ?> monWarm;
    @FXML
    private Button addButton;

    @FXML
    private StackPane addPane1;


    public void initialize(){
        plan = Trainer.createPlan();
        System.out.println(plan);
    }

    public void showSessionPane() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane sessionDialogBox = fxmlLoader.load(getClass().getResource("SessionEditor.fxml"));
        SessionController sessionController=new SessionController();
        Dialog<ButtonType> dialog1 = new Dialog<>();
        dialog1.setDialogPane((DialogPane) sessionDialogBox);
        Optional<ButtonType> clickedButton = dialog1.showAndWait();
        if (clickedButton.get()==ButtonType.APPLY){
            plan.addSession(SessionController.session,sessionController.selectedDay);
            addSession(SessionController.sessionsList,sessionController.selectedDay);
        }

    }

    public void addSession(ObservableList<Session> sessionList, int day){
        ObservableList<Session> sessionCopy= FXCollections.observableArrayList();
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

}
