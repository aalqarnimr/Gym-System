package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.io.*;
import java.lang.reflect.Member;
import java.net.URL;
import java.util.*;

public class APIComm implements Initializable {


    static Workout[] workouts ;
    static ObservableList<Workout> avaliableWorkouts= FXCollections.observableArrayList();
    static ObservableList<Plan> savedPlans=FXCollections.observableArrayList();

    public static ObservableList<Plan> getPlans(){
        return savedPlans;
    }
    public static void addPlanToDatabase(Plan p){
        savedPlans.add(p);
    }

    public static void addToDataBase(Workout w){
        avaliableWorkouts.add(w);
    }
    static List<Trainer> trainerList=new ArrayList<>();

    static List<Trainee> traineeList=new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public static void getInfo() throws IOException {
        FileInputStream fstream = new FileInputStream("PlansDatabase.bin");
        try {
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                Object obj;
                try {
                    obj = ostream.readObject();
                    savedPlans.add((Plan) obj);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } finally {
            fstream.close();
        }
    }
    public static String generateUserName(){
        String userName;
        int x=(int)(Math.random()*100000);

        userName="Admin "+x;
        return userName;
    }
    public static String generatePassword(){
        int counter=0;
        String password="";
        while (counter<10) {
            int random = (int) (Math.random() * 62);

            if (random <= 9) {
                int ascii = random + 48;
                password = password + (char) ascii;
            } else if (random <= 35) {
                int ascii = random + 55;
                password = password + (char) ascii;

            } else {
                int ascii = random + 61;
                password = password + (char) ascii;

            }
            counter++;
        }
        return password;
    }
    public static void WriteObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream("PlansDatabase.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
