package com.Treadsex.MomoBobo.MomoBobo.MicroCatMicroDog;

public class MicroCat implements Runnable {
    int num;
    MicroCat(int i){
        this.num = i;
    }
    public void run(){
        for (int i=0; i<num; i++){
            System.out.println("Miau Miau");
        }
    }

}
