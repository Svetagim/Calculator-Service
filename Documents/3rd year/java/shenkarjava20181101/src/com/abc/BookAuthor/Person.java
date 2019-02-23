package com.abc.BookAuthor;

public class Person {
    private java.lang.String name;
    private long id;

    public Person(String name, long id) {
        this.name = name;
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
