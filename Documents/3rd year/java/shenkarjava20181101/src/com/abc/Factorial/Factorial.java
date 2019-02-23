package com.abc.Factorial;

class FactorialApplication
{

    public static void main(String args[])
    {
        long number, result;
        number = 6;
        result = factorial(number);
        System.out.println("The factorial of "+number+" is: "+result);
    }

    public static long factorial(long value)
    {

        long result = 1;

        for(int i=1 ; i<=value; i++)
            result*=i;

        return result;
    }

}