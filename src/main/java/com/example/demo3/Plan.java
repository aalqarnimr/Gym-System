package com.example.demo3;

import java.util.Arrays;
import java.util.Dictionary;

public class Plan {
    Session[] sessions=new Session[7];
    int[] busyDays;

    private String name="unnamed";

    public Plan(){
        busyDays = new int[]{0, 0, 0, 0, 0, 0, 0};
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
         this.name = name;
    }

    void addSession(Session session,int day){
        if (!session.isCompleted()) return;
        sessions[day]=session;
        busyDays[day]=1;
    }
    void removeSession(int day){
        if (busyDays[day]==0)
            return;
        sessions[day]=null;
        busyDays[day]=0;
    }

    boolean isCompleted(){
        for (int i=0;i<busyDays.length;i++){
            if (busyDays[i]==1)
                return true;
        }

        return false;
    }
    public String toString(){
        return name;

    }

}
