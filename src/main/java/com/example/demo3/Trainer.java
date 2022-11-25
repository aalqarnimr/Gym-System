package com.example.demo3;

import java.util.List;

public class Trainer extends Member{



    Plan createPlan(){
        return new Plan();
    }

    public void savePlan(Plan p){
        if (!p.isCompleted())
            return;
        APIComm.addPlan(p);
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
