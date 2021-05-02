package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {
    public static void main(String[] args) {
        MThread t=new MThread();
        Thread th=new Thread(t);
        ExecutorService ex= Executors.newFixedThreadPool(10);
        ex.execute(th);
        th.start();
    ex.shutdown();
    }


}
class MT implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
