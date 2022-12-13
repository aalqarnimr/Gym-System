package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class signIn {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void backToWlc(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("wlcPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void signInMessage(ActionEvent event){
        System.out.println("SIGNED IN!");
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("https://us-central1-swe206-221.cloudfunctions.net/app/SignIn");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();

            if (responseCode != 200){
                throw new RuntimeException("HttpResponseCode: "+ responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()){
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(informationString);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
