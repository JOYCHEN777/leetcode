package test;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        MyYield m=new MyYield();
        //start()---> 就绪状态，什么时候运行，是由cpu决定。
        Thread t=new Thread(m,"a");
        Thread t2=new Thread(m,"b");
        t.start();

        for(int i=0;i<500;i++){
            System.out.println("main"+i);
            if(i==200) t.join();
            /**
             * 调用join方法，会让main线程blocked
             * 所以可以看到 在i<200之前
             * main和a线程是交替执行的
             * 200之后就是a强制执行
             * 输出如下（部分）：
             * a----------72
             * main197
             * a----------73
             * main198
             * a----------74
             * main199
             * a----------75
             * main200
             * a----------76
             * a----------77
             * a----------78
             * a----------79
             * a----------80
             * a----------81
             */
        }
    }

}


