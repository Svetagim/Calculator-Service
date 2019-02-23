package com.Treadsex.MomoBobo.MomoBobo.LeftRight;

public class LeftRight {
    public static void main(String args[]) throws Exception
    {
        Thread t1 = new Thread(new Right());
        Thread t2 = new Thread(new Left());
        t1.run();
        t2.run();
        t1.join();
        t2.join();
    }
}
