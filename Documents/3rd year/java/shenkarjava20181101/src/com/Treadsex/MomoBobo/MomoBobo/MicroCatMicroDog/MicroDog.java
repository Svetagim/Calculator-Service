package com.Treadsex.MomoBobo.MomoBobo.MicroCatMicroDog;


public class MicroDog implements Runnable {
    int num;
    MicroDog(int i){
        this.num = i;
    }
    public void run(){
        for (int i=0; i<num; i++){
            System.out.println("Hau Hau");
        }
    }

}
