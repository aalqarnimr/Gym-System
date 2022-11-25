package com.example.demo3;

public class Trainee extends Member {
    Plan plan;

    public Trainee(Plan p){
        plan=p;
    }



    public Plan getPlan(){
        return plan;
    }
    public void setPlan(Plan plan){
        this.plan = plan;
    }

}
