package com.abc.person;

public class Application
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Person obA, obB, obC, obD;
        obA = new Person(123123,"dave","ron");
        obB = new Person(633424,"Jack","Bauer");
        obC = new Person(123435,"Steve");
        obD = new Person(11111);
        System.out.println(obA.toString());
        System.out.println(obB.toString());
        System.out.println(obC.toString());
        System.out.println(obD.toString());
    }

}