package com.Treadsex.MomoBobo.MomoBobo.LeftRight;

public class Right implements Runnable {
    Right(){
        super();
    }
    public void run(){
        for (int i=0; i<1000; i++){
            System.out.println("Right");
        }
    }

}
