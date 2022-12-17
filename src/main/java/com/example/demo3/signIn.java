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

    }
    public void signInMessage(ActionEvent event){
        System.out.println("SIGNED IN!");
    }
    public static void main(String[] args) {

    }

}
