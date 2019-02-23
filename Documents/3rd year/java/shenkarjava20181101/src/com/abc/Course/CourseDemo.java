package com.abc.Course;


public class CourseDemo
{
    public static void main(String args[])
    {
        Teacher lecturer = new Teacher("Moshe",33242424);
        Course softwareFirstCourse = new Course(12,"Java Basic",lecturer);
        Course softwareSecondCourse = new Course(13,"Java Advanced",lecturer);
        System.out.println("The "+softwareFirstCourse.getName()
                +" course is lectured by "+softwareFirstCourse.getTeacher().getName());
        System.out.println("The "+softwareSecondCourse.getName()
                +" course is lectured by "+softwareFirstCourse.getTeacher().getName());
    }
}