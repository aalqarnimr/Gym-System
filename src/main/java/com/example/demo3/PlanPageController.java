package com.example.demo3;

import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class PlanPageController {
    private Plan plan;

    @FXML
    private Button savePlanButton;
    @FXML
    private Text feedbackText;
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

    @FXML
    private Button DdoneButton;

    @FXML
    private Text nameFeedBack;

    @FXML
    private TextField nameTextfield;


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
            if (SessionController.session.isCompleted())
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
    public void homePage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SessionEditor.fxml"));
        Stage stage = (Stage) savePlanButton.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void savePlan() throws IOException, InterruptedException {
        Trainer.savePlan(plan);
        if (!plan.isCompleted())
            feedbackText.setText("error: the plan is not completed");
        else{
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane sessionDialogBox = fxmlLoader.load(getClass().getResource("SetPlanName-view.fxml"));
            Dialog<ButtonType> dialog1 = new Dialog<>();
            dialog1.setDialogPane((DialogPane) sessionDialogBox);
            Optional<ButtonType> clickedButton = dialog1.showAndWait();
            if (clickedButton.get() == ButtonType.OK){
                homePage();
            }
        }
    }
    public void setName(){
        if (nameTextfield.getText().length()!=0)
            plan.setName(nameTextfield.getText());
        else
            plan.setName("unnamed");

    }

}
