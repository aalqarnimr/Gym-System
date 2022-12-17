package com.example.demo3;

import java.io.Serializable;

public class Trainee extends Member implements Serializable {
    Plan plan;
    String traineeID;




    public Trainee(){
        this("null",0,0,"null","null","null",null);
    }

    public Trainee(String traineeID){
        this("null",0,0,"null","null",traineeID,null);
    }
    public Trainee(String name,double height,double weight,String userName,String passWord,String traineeID,Plan plan){
        super(name,height,weight,userName,passWord);
        this.traineeID=traineeID;
        this.plan=plan;
    }





    public Plan getPlan(){
        return this.plan;
    }
    public void setPlan(Plan plan){
        this.plan = plan;
    }
    public String getId(){
        return this.traineeID;
    }
    public void setId(String traineeID){
        this.traineeID = traineeID;
    }
    public String toString(){
        return "Name: "+super.name+"   ID: "+this.traineeID;
    }
}
