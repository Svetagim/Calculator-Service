package com.abc.Course;

import javax.naming.Name;

public class Course {
    private int code;
    private String name;
    private Teacher teacher;

    public int getCode() {return this.code;}
    public String getName() {return this.name;}
    public Teacher getTeacher() {return this.teacher;}
    public void setName(String name) {this.name=name;}
    public void setTeacher(Teacher teacher) {this.teacher=teacher;}

    public Course(int code, String name, Teacher teacher){
        this.code=code;
        setName(name);
        setTeacher(teacher);
    }

}
