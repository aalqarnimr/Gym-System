package com.example.demo3;

import java.io.Serializable;

public class Member implements Serializable {
    String name;
    double height;
    double weight;
    String userName;
    String passWord;
    String imgPath;

    private static final long serialVersionUID = 6529685098267757422L;

    public Member(String name,double height,double weight,String userName,String passWord,String imgPath){
        this.name=name;
        this.height=height;
        this.weight=weight;
        this.userName=userName;
        this.passWord=passWord;
        this.imgPath=imgPath;
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
    public String getImgPath(){return this.imgPath;}

    public void setName(String name){this.name=name;}
    public void setHeight(double height){
        this.height=height;
    }
    public void setWeight(double weight){
        this.weight=weight;
    }
    public void setUserName(String userName){this.userName=userName;}
    public void setPassWord(String passWord){this.passWord=passWord;}
    public void setImgPath(String imgPath){this.imgPath=imgPath;}



    public String toString(){
        return "Name: "+this.name+"\nHeight: "+this.height+"\nWeight: "+this.weight;
    }
}
