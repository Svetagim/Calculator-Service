package com.Treadsex.MomoBobo.MomoBobo.CountDown;

import java.util.concurrent.CountDownLatch;

class PrintNumbers extends Thread
{
    CountDownLatch latch;
    PrintNumbers(CountDownLatch c)
    {
        latch = c;
    }
    public void run()
    {
        for(int i = 0; i<10; i++)
        {
            System.out.println(Thread.currentThread().getName()+" .. "
                    +(int)(100*Math.random()));
            latch.getCount();
        }
    }
}