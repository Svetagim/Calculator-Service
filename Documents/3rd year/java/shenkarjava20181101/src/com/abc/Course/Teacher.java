package com.abc.Course;

public class Teacher {
    private long id;
    private String name;

    public long getId(){return this.id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public Teacher(String name, long id){
        this.id=id;
        setName(name);
    }
}

