package com.abc.BlindDate;

import java.util.Date;

public class Person {
    private java.lang.String name;
    private long id;
    private java.util.Date birthday;

    public Person(java.lang.String name, long id){
        this.name = name;
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                '}';
    }
}
