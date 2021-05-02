package test;

import java.util.ArrayList;
import java.util.Vector;

public class MC implements Runnable {
    private static int index=0;
    private static ArrayList<Integer> list;
    public static
    volatile int min=Integer.MAX_VALUE;
    public static volatile boolean flag=true;

    public MC(){
        list=new ArrayList<>();
        list.add(39);
        list.add(40);
        list.add(13);
        list.add(18);
        list.add(9);
        list.add(1);

    }

    @Override
    public void run() {
        while(index<list.size()){
            min=Math.min(min,list.get(index));
            index++;
            System.out.println(Thread.currentThread().getName()+":"+min);
        }
        if(index==list.size()){
            flag=false;
        }

    }

}
class T{
    public static void main(String[] args) {
        MC m1=new MC();
        MC m2=new MC();
        new Thread(m1,"a").start();
        new Thread(m2,"b").start();
        int res=0;
        while(MC.flag){
            //do nothing,just waiting for the MyThread.flag become flase
            //which means the thread's end
            //in order to get the finally result of the nearst city
        }
        System.out.println(">>>>>>>>>>"+MC.min);

    }
}
