package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class PlanListPageController {

    static Plan selectedPlan;
    @FXML
    private Button EditPlanButton;

    @FXML
    private Text feedText;

    @FXML
    private ListView<Plan> plansListView;

    public void initialize(){
        selectedPlan=null;
        plansListView.getItems().addAll(APIComm.getPlans());
        MainPageController.isEdit=true;
    }
    public void setPlanToEdit() throws IOException {
        selectedPlan= (Plan) plansListView.getSelectionModel().getSelectedItem();
        if (selectedPlan==null)
            feedText.setText("error: user didn't choose plan");
        else {
            Parent root = FXMLLoader.load(getClass().getResource("AddPlan-view.fxml"));
            Stage stage = (Stage) EditPlanButton.getScene().getWindow();
            Scene scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
    public void homePage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage stage = (Stage) feedText.getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
