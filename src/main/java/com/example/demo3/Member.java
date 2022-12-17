package com.example.demo3;

import java.io.Serializable;

public class Member implements Serializable {
    String name;
    double height;
    double weight;
    String userName;
    String passWord;

    public Member(String name,double height,double weight,String userName,String passWord){
        this.name=name;
        this.height=height;
        this.weight=weight;
        this.userName=userName;
        this.passWord=passWord;
    }

    public String getName(){
        return this.name;
    }
    public double getHeight(){
        return this.height;
    }
    public double getWeight(){
        return this.weight;
    }
    public String getUserName(){return this.userName;}
    public String getPassWord(){return this.passWord;}
    public void setName(String name){this.name=name;}
    public void setHeight(double height){
        this.height=height;
    }
    public void setWeight(double weight){
        this.weight=weight;
    }
    public void setUserName(String userName){this.userName=userName;}
    public void setPassWord(String passWord){this.passWord=passWord;}


    public String toString(){
        return "Name: "+this.name+"\nHeight: "+this.height+"\nWeight: "+this.weight;
    }
}
