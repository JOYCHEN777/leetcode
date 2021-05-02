package test;

public class Test03 {
    private volatile int flag = 0;
    private int i = 0;


    public void runThread() throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        new Thread(t1, "a").start();
        new Thread(t2, "b").start();
        new Thread(t3, "c").start();

    }

    public class T1 implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    flag = 1;
                }

            }
        }
    }

    public class T2 implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 1) {
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    flag = 2;
                }

            }
        }
    }

    public class T3 implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 2) {
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    flag = 0;
                }

            }
        }
    }
}
