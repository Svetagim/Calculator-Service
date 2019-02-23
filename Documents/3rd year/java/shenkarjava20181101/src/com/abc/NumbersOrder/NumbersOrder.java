package com.abc.NumbersOrder;

public class NumbersOrder {
    public static void main(String args[]) {
        int vec[] = {1, 2, 3, 65, 23, 78, 5, 2, 1, 234, 23, 21, 2, 23, 323, 1111, 21};
        int temp;
        for (int i=0; i< vec.length; i++)
            for (int j=i+1; j< vec.length; j++){
                if (vec[j] < vec[i]){
                    temp=vec[i];
                    vec[i]=vec[j];
                    vec[j]=temp;
                }
            }

        for (int index = 0; index < vec.length; index++) {
            System.out.println(vec[index]);
        }
    }
}