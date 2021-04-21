package test;

import JZOF.T;

public class TestThread extends Thread {
    private static int t=0;

    public void  run() {
        for(int i=0;i<10;i++){
            TestThread.add();
            System.out.println(Thread.currentThread().getName()+":"+t);

        }try {


            sleep(100);
        }catch (InterruptedException ie){
            System.out.println(ie.toString());
        }
    }
    public static synchronized void add(){
        t+=1;
    }

}
