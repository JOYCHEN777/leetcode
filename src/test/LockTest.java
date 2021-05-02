package test;

public class LockTest implements Runnable {
    private static int obj1 = 0;
    private static int obj2 = 100;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + obj1++);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.yield();
        synchronized (this) {
            for (int i = 0; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + obj2++);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
