package com.example.demo3;

import java.io.Serializable;
import java.net.URI;

public class Workout implements Serializable {
    private String name;
    String targetedMuscles;
    private int targetedSets;
    private static final long serialVersionUID = 6529685098267757690L;

    //For progress
    double goalWeight;
    double targetedWeight;

    int sets;

    int goalRepetitions;
    int actualRepetitions;

    double volumeProgress;

    String youtubeLink;

    public Workout(String name){
        this.name = name;
    }
    public Workout(String name,double targetWeight,int sets,int goalRepetitions,int actualRepetitions,double volumeProgress,String muscles,String youtubeLink){
        this.name = name;
        this.targetedWeight = targetWeight;
        this.sets = sets;
        this.goalRepetitions = goalRepetitions;
        this.actualRepetitions = actualRepetitions;
        this.volumeProgress = volumeProgress;
        this.youtubeLink = youtubeLink;
        targetedMuscles = muscles;
    }


    public String toString(){
        return name;
    }

    public String getName(){
        return name;
    }

    public double getVolumeProgress() {
        return this.volumeProgress = this.actualRepetitions * this.targetedWeight * sets;
    }
}
