package Philosophers;

import java.util.ArrayList;

public class Philosopher extends Thread{
    ArrayList<String > table = new ArrayList<>();
    String name;

    Philosopher(String name){
        this.name = name;
    }

    @Override
    public void run() {
        try{
            if (table.size() < 2){
                table.add(name);
                System.out.printf("%s кушает \n", name);
                sleep(1000);
                System.out.printf("%s поел \n", name);
                table.remove(name);
                sleep(1000);
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
