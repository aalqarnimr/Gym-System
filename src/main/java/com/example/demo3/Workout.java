package com.example.demo3;

import java.io.Serializable;

public class Workout implements Serializable {
    private String name;
    private String targetedMuscles;
    private int targetedSets;

    //For progress
    double goalWeight;
    double targetedWeight;

    int sets;

    int goalRepetitions;
    int actualRepetitions;

    double volumeProgress;

    public Workout(String name){
        this.name = name;
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
