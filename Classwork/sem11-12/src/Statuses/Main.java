package Statuses;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println(getState());
            }
        };
        System.out.println(t.getState());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.notifyAll();
                        lock.wait();
                        //lock.wait(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        synchronized (lock){
            thread.start();
            lock.wait();
            System.out.println(thread.getState());
            lock.notifyAll();
            System.out.println(thread.getState());
        }
    }
}
