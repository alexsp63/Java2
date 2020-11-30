import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class Philosopher extends Thread{
    Semaphore table;
    boolean full = false;
    String name;

    Philosopher(Semaphore table, String name){
        this.table = table;
        this.name = name;
    }

    @Override
    public synchronized void run() {
        try{
            if (!full){
                table.acquire();
                System.out.printf("%s кушает \n", name);
                sleep(1000);
                full = true;
                System.out.printf("%s поел \n", name);
                table.release();
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
