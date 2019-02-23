package com.abc.NumbersForLoop;

public class NumbersForLoop {
    public static void main(String args[])
    {
        for(int i=1; i<=100; i++){
            System.out.print("'Num "+i+" is: ");
            if (i%2==0)
                System.out.println("devides by 2, ");
            else
                System.out.println("does not devide by 2, ");
            if (i%3==0)
                System.out.println("devides by 3, ");
            else
                System.out.println("does not devide by 3, ");
            if (i%4==0)
                System.out.println("devides by 4, ");
            else
                System.out.println("does not devide by 4, ");
            if (i%5==0)
                System.out.println("devides by 5, ");
            else
                System.out.println("does not devide by 5, ");
        }
    }
}
