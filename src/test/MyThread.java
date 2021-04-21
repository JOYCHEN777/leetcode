package test;

public class MyThread implements Runnable{
    private volatile boolean flag=true;
    private volatile int  sum=0;
    @Override
    public void run() {
        int i=1;
        while(flag){
            System.out.println(Thread.currentThread().getName()+"--->"+sum++);
        }
    }
    public void stop(){

        this.flag=false;
    }
    public static void main(String[] args) {
        MyThread t=new MyThread();
        new Thread(t).start();
        new Thread(t).start();
        for (int i=0;i<2000;i++){
            System.out.println(" ");
            if(i==1999){
                System.out.println(t.sum);
                t.stop();
                System.out.println("over");
            }
        }






    }
}