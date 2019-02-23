package com.abc.demos;

import com.abc.samples.*;

public class MyProgram {

    public static void main(String argv[]) {

        //System.out.print("we love java! ");   \
        //System.out.println("we love php!");

        com.abc.samples.Rectangle recA, recB;
        recA = new com.abc.samples.Rectangle(4,5);
        recB = new Rectangle(4,5);


        if(recA.equals(recB)) {
            System.out.println("equals!");
        } else {
            System.out.println("not equals!");
        }

    }

}
