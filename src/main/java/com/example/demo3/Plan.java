package com.example.demo3;

import java.util.Dictionary;

public class Plan {
    private Session[] sessions;
    private int[] busyDays;

    private String []weeklyDays;
    private String name;

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
        if (busyDays[day]==1)
            return;
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
        if (sessions.length==0)
            return false;
        return true;
    }

}
