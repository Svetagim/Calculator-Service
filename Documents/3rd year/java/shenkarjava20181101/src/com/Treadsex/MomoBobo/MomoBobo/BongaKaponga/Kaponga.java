package com.Treadsex.MomoBobo.MomoBobo.BongaKaponga;

public class Kaponga implements Runnable {
    int num;
    Kaponga(int i){
        this.num = i;
    }
    public void run(){
        for (int i=0; i<num; i++){
            System.out.println("Kaponga");
        }
    }

}

