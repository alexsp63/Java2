package Classwork;

public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        t.isAlive();

    }
}
