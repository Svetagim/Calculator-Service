package com.abc.Multi;

public class Multi {
    public static void main(String args[])
    {
        for (int i=1; i<=10; i++)
            for(int j=1; j<=10; j++) {
                if (j == 10)
                    System.out.println(i * j);
                else
                    System.out.print(i * j+" ");
            }
    }
}
