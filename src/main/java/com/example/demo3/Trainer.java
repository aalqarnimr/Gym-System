package com.example.demo3;

import java.util.LinkedList;
import java.util.List;

public class Trainer extends Member{

    String specialty;
    List<Trainee> traineeList;
    String trainerID;

    public Trainer(){
        this("null",0,0,"null","null","null","null");
    }
    public Trainer(String trainerID){
        this("null",0,0,"null","null","null",trainerID);
    }

    public Trainer(String name,double height,double weight,String userName,String passWord,String specialty,String trainerID){
        super(name,height,weight,userName,passWord);
        this.specialty=specialty;
        this.traineeList=new LinkedList<>();
        this.trainerID= this.trainerID;
    }

    public String getSpecialty(){
        return this.specialty;
    }
    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }
    public List<Trainee> getTraineeList(){
        return traineeList;
    }
    public void setTraineeList(List<Trainee> traineeList){
        this.traineeList=traineeList;
    }





    static Plan createPlan(){
        return new Plan();
    }

    public static void savePlan(Plan p){
        if (!p.isCompleted())
            return;
        APIComm.addPlanToDatabase(p);
    }
    public void addTrainee(Trainee trainee){
        this.traineeList.add(trainee);
    }
    public boolean checkTrainee(String id){
        boolean checker =false;

        for (int i=0; i<this.traineeList.size();i++){
            if (trainerID==this.traineeList.get(i).getId()){
                checker=true;
                break;
            }
        }
        return checker;
    }




//    public void getPlan(String planName) {
//        for (int i = 0 ; i<getPlans().length;i++) {
//
//
//        }
//    }

//    public Plan[] getPlans(){
//    }

}
