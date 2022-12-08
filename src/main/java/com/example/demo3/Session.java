package com.example.demo3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Session {

    List<Workout> normSession=new LinkedList<>();
    List<Workout> warmupSession=new LinkedList<>();


    public Session(){

    }
    void addWorkout(Workout work, int session){    // 0 = normal ,1=warmup
        if (session==0)
            normSession.add(work);
        else
            warmupSession.add(work);
    }


    void DeleteWorkout(Workout work,int session){

    }

    boolean isCompleted(){
        if (normSession.size()==0||warmupSession.size()==0)
            return false;
        return true;
    }
    public List<Workout> getNormSession(){
        return normSession;
    }

    public List<Workout> getWarmupSession(){
        return warmupSession;
    }
    public String toString(){
        return normSession.toString();
    }
}
