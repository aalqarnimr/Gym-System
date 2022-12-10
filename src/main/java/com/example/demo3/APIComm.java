package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public static void getInfo(){
        workouts = new Workout[]{new Workout("push up"), new Workout("pull up"), new Workout("Lunges"),new Workout("Dumbbell rows"), new Workout("Chest Press"),new Workout("Leg Press")};
        Plan startingStrength = new Plan();
        Session s1 = new Session();
        s1.addWorkout(workouts[0],1);
        s1.addWorkout(workouts[4],0);
        s1.addWorkout(workouts[5],0);
        Session s2 = new Session();
        s2.addWorkout(workouts[1],1);
        s2.addWorkout(workouts[3],0);
        Session s3 = new Session();
        s3.addWorkout(workouts[4],0);
        s3.addWorkout(workouts[5],0);
        s3.addWorkout(workouts[0],1);
        Session s4 = new Session();
        s4.addWorkout(workouts[1],1);
        s4.addWorkout(workouts[3],0);
        Session s5 = new Session();
        s5.addWorkout(workouts[0],1);
        s5.addWorkout(workouts[0],0);
        Session s6 = new Session();
        s6.addWorkout(workouts[1],1);
        s6.addWorkout(workouts[4],0);
        s6.addWorkout(workouts[5],0);
        Session s7 = new Session();
        s7.addWorkout(workouts[2],1);
        s7.addWorkout(workouts[4],0);
        s7.addWorkout(workouts[5],0);
        Session[] strSessions = {s1,s2,s3,s4,s5,s6,s7};
        startingStrength.busyDays = new int[]{1, 1, 1, 1, 1, 1, 1};
        startingStrength.sessions=strSessions;
        startingStrength.setName("Starting strength");
        savedPlans.add(startingStrength);
        Plan strongLifts = new Plan();
        Session[] slSessions = {new Session(),new Session(),new Session(),new Session(),new Session()};
        int[] days = {0,1,4,5,6};
        for (int i= 0;i<days.length;i++){
            slSessions[i].addWorkout(workouts[0],1);
            slSessions[i].addWorkout(workouts[1],1);
            slSessions[i].addWorkout(workouts[3],0);
            slSessions[i].addWorkout(workouts[4],0);
            slSessions[i].addWorkout(workouts[5],0);
            strongLifts.addSession(slSessions[i],days[i]);
        }
        strongLifts.setName("Strong Lifts");
        savedPlans.add(strongLifts);
    }
}
