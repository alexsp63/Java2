package Statuses;

public class Main2 {

    public static void main(String[] args) {
        Object lock = new Object();
        new SyncThread(lock).start();
        new SyncThread(lock).start();
    }
}
