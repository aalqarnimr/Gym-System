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
    static ArrayList<Trainer> trainerList=new ArrayList<Trainer>();

    static ArrayList<Trainee> traineeList=new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public static void getInfo() throws IOException {
        workouts = new Workout[]{new Workout("push up"), new Workout("pull up"), new Workout("Lunges"),new Workout("Dumbbell rows"), new Workout("Chest Press"),new Workout("Leg Press")};
        loadPlans();
        loadTrainers();
        loadTrainee();
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
    public static void WriteObjectToFile(ObservableList<Plan> plansList) {

        try {
            FileOutputStream fileOut = new FileOutputStream("plansDataBase.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(new ArrayList<Plan>(plansList));
            objectOut.close();
            System.out.println("The Plans was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void loadPlans() throws IOException {
        FileInputStream fstream = new FileInputStream("plansDataBase.bin");
        try {
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                Object obj;
                try {
                    obj = ostream.readObject();
                    savedPlans.addAll((Collection<? extends Plan>) obj);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }finally {
            fstream.close();
        }
    }

    public static void WriteTrainerToFile(ArrayList<Trainer> arr) {

        try {
            FileOutputStream fileOut = new FileOutputStream("TrainersDataBase.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(arr);
            objectOut.close();
            System.out.println("The Plans was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void loadTrainers() throws IOException {
        FileInputStream fstream = new FileInputStream("TrainersDataBase.bin");
        try {
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                Object obj;
                try {
                    obj = ostream.readObject();
                    trainerList.addAll((Collection<? extends Trainer>) obj);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }finally {
            fstream.close();
        }
    }

    public static void WriteTraineeToFile(ArrayList<Trainee> arr) {

        try {
            FileOutputStream fileOut = new FileOutputStream("TraineesDataBase.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(arr);
            objectOut.close();
            System.out.println("The Trainee was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void loadTrainee() throws IOException {
        FileInputStream fstream = new FileInputStream("TraineesDataBase.bin");
        try {
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                Object obj;
                try {
                    obj = ostream.readObject();
                    trainerList.addAll((Collection<? extends Trainer>) obj);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }finally {
            fstream.close();
        }
    }
}
