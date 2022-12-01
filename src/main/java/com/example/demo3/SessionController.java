package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;

public class SessionController {
    static Session session;
    static int selectedDay ;

    static ObservableList<Session> sessionsList= FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> choiceDay;

    @FXML
    private RadioButton radioNorm;

    @FXML
    private RadioButton radioWarm;

    @FXML
    private TableColumn<?, ?> normTable;

    @FXML
    private TableColumn<?, ?> warmTable;

    @FXML
    private TableView<Session> sessionTable;

    @FXML
    private ListView<Workout> workList;
    @FXML
    public void initialize(){
        sessionsList= FXCollections.observableArrayList();
        session = new Session();
        choiceDay.getItems().add("sunday");
        choiceDay.getItems().add("monday");
        choiceDay.getItems().add("Teusday");
        choiceDay.getItems().add("Wednesday");
        choiceDay.getItems().add("Thursday");
        choiceDay.getItems().add("friday");
        choiceDay.getItems().add("Saturday");
        choiceDay.setValue("Choose a Day");
        workList.getItems().add(new Workout("w"));
        workList.getItems().add(new Workout("e"));
    }

    public void showRadio(){
        radioNorm.setVisible(true);
        radioWarm.setVisible(true);
    }

    public void showWorkList(){
        workList.setVisible(true);

    }

    public void addWorkout(){
        Workout ss= workList.getSelectionModel().getSelectedItem();
        if (radioNorm.isSelected()){
            session.addWorkout(ss,0);
        }
        else if (radioWarm.isSelected()){
            session.addWorkout(ss,1);
        }
        sessionsList.add(session);
        sessionTable.setItems(sessionsList);
        normTable.setCellValueFactory(new PropertyValueFactory<>("normSession"));
        warmTable.setCellValueFactory(new PropertyValueFactory<>("warmupSession"));
    }

    public void getDay(){
        selectedDay = choiceDay.getSelectionModel().getSelectedIndex();
    }



}
