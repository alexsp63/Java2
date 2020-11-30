import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore place = new Semaphore(2);
        Philosopher philosopher1 = new Philosopher(place,"1");
        Philosopher philosopher2 = new Philosopher(place, "2");
        Philosopher philosopher3 = new Philosopher(place, "3");
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
    }
}
