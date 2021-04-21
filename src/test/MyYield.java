package test;

import JZOF.TreeNode;

import static java.lang.Thread.sleep;

public class MyYield implements Runnable {
    @Override
    public void run() {
        try {
            sleep(1);
        }catch (InterruptedException e){

        }
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"----------"+i);
        }



    }
}
