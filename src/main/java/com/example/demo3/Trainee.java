package com.example.demo3;

public class Trainee extends Member {
    Plan plan;
    int id;


    public Trainee(int id){
        this("null",0,0,"null","null",id,null);
    }
    public Trainee(String name,double height,double weight,String userName,String passWord,int id,Plan plan){
        super(name,height,weight,userName,passWord);
        this.id=id;
        this.plan=plan;
    }




    public Plan getPlan(){
        return this.plan;
    }
    public void setPlan(Plan plan){
        this.plan = plan;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String toString(){
        return "Name: "+this.name+"   ID: "+this.id;
    }
}
