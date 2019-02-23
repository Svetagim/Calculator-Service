package com.abc.Fibonacci;

public class Fibonacci {
    public static void main(String args[])
    {
        fibo();
    }

    public static void fibo()
    {
        int num1=0;
        int num2=1;
        int tmp;

        for(int i=0 ; i<=20; i++)
            if (i==0)
                System.out.print(num1+" ");
            else if (i==1)
                System.out.print(num2+" ");
            else
            {
                tmp= num1+num2;
                System.out.print(tmp+" ");
                num1=num2;
                num2=tmp;
            }
    }

}
