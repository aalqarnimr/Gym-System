package com.example.demo3;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;

public class SessionController {

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
    private TableView<Workout> sessionTable;


    @FXML
    private ListView<Workout> workList;
    @FXML
    public void initialize(){
        choiceDay.getItems().add("sunday");
        choiceDay.getItems().add("monday");
        choiceDay.setValue("Choose a Day");
        workList.getItems().add(new Workout("w"));

    }


    public void showRadio(){
        radioNorm.setVisible(true);
        radioWarm.setVisible(true);
    }

    public void showWorkList(){
        workList.setVisible(true);

    }

    public void addTo(){
        ObservableList<Workout> ss= workList.getSelectionModel().getSelectedItems();
        sessionTable.setItems(ss);
        normTable.setCellValueFactory(new PropertyValueFactory("name"));

    }


}
