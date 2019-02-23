package com.abc.Utility;

public class Utility {
    private int num;
    public Utility(int num){this.num = num;}
    public int numOfDigits(){
        int i=this.num;
        int count=0;
        while (i>0){
            i=i/10;
            count+=1;
        }
        return count;
    }
    public int sumOfDigits(){
        int i=this.num;
        int sum=0;
        while (i>0){
            sum+=i%10;
            i=i/10;
        }
        return sum;
    }
}
