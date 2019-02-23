package com.Treadsex.MomoBobo.MomoBobo;

import com.Treadsex.MomoBobo.MomoBobo.RunnableObject;

import java.util.concurrent.Semaphore;

public class MomoBoboThreads
{
    public static void main(String args[]) throws Exception
    {
        Semaphore semaphore = new Semaphore(1, true);
        Thread t1 = new Thread(new RunnableObject(semaphore, "BOBO"));
        Thread t2 = new Thread(new RunnableObject(semaphore, "MOMO"));
        t1.run();
        t2.run();
        t1.join();
        t2.join();
        System.out.println("Both t1 and t2 ended");
    }
}

