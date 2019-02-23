package com.Treadsex.MomoBobo.MomoBobo.BongaKaponga;

public class Bonga implements Runnable {
    int num;
    Bonga(int i){
        this.num = i;
    }
    public void run(){
        for (int i=0; i<num; i++){
            System.out.println("Bonga");
        }
    }

    }
