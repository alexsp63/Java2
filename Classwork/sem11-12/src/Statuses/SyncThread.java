package Statuses;

public class SyncThread extends Thread{
    private Object lock;

    public SyncThread(Object object) {
        lock = object;
    }

    public void run() {
        synchronized (lock) {
            try {
                System.out.println(getName());
                lock.notify();
                lock.wait();
            } catch (InterruptedException e) {}
            lock.notify();
        }
    }
}
