package com.example.demo3;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class APIComm {

    static List<Workout> avaliableWorkouts=new ArrayList<>();
    static List<Plan> savedPlans=new ArrayList<>();

    public static List<Plan> getPlans(){
        return savedPlans;
    }
    public static void addPlanToDatabase(Plan p){
        savedPlans.add(p);
    }

    public static void addToDataBase(Workout w){
        avaliableWorkouts.add(w);
    }

}
