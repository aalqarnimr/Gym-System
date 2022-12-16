package com.example.demo3;

import java.io.Serializable;

public class Workout implements Serializable {
    private String name;
    private String targetedMuscles;
    private int targetedSets;
    public Workout(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public String getName(){
        return name;
    }
}
