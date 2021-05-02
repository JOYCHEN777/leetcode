package test;

import static java.lang.Thread.sleep;

public class MThread implements Runnable{
    private int count=1;
    @Override
    public void run() {
        while(count<=100){
            System.out.println(Thread.currentThread().getName()+":"+count++);
        }

        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
