package com.Treadsex.MomoBobo.MomoBobo.LeftRight;

public class Left implements Runnable {
    Left(){
        super();
    }
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println("Left");
        }
    }

}
