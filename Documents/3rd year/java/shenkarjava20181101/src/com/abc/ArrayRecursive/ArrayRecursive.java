package com.abc.ArrayRecursive;

public class ArrayRecursive {
    private int arr[]= {1,2,3,4,5};

    public int rec(int num){
        if (arr.length<num)
            return  -1;
        if (num==1)
            return arr[0];
        return arr[num-1]+rec(num-1);
    }

}
