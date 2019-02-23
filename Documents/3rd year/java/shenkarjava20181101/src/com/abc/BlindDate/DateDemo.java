package com.abc.BlindDate;

public class DateDemo {
    public static void main(String[] args){
        Person sveta = new Person("Sveta", 30867);
        Person lior = new Person("Lior", 0625);
        BlindDate ourdate = new BlindDate(lior,sveta,true);
        System.out.print(ourdate);
    }
}
