package com.abc.Students;

public class StudentDemo
{
    public static void main(String[] args)
    {
        Student bestStudent = new Student("Moshe",4888482,92);
        Student funniestStudent = new Student("David",2323232,84);
        System.out.println("The best student is "+bestStudent);
        System.out.println("The funniest student is "+funniestStudent);
    }
}