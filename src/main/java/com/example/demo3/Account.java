package com.example.demo3;

public class Account {
    static Member currentMember;

    public static void setCurrentUser(Member m){
        currentMember = m;
    }
    public static Member getCurrentUser(){
        return currentMember;
    }

}
