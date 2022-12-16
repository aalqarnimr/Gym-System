package com.example.demo3;

import java.util.LinkedList;
import java.util.List;

public class Trainer extends Member{

    String specialty;
    List<Trainee> traineeList;
    int trainerNumber;

    public Trainer(){
        this("null",0,0,"null","null","null",0);
    }
    public Trainer(int trainerNumber){
        this("null",0,0,"null","null","null",trainerNumber);
    }

    public Trainer(String name,double height,double weight,String userName,String passWord,String specialty,int trainerNumber){
        super(name,height,weight,userName,passWord);
        this.specialty=specialty;
        this.traineeList=new LinkedList<>();
        this.trainerNumber=trainerNumber;
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
    public boolean checkTrainee(int id){
        boolean checker =false;

        for (int i=0; i<this.traineeList.size();i++){
            if (id==this.traineeList.get(i).getId()){
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
