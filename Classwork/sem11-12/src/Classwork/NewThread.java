package Classwork;

public class NewThread extends Thread{

    NewThread(String name){
        super(name);
    }

    public void run(){
        System.out.printf("%s started\n", Thread.currentThread().getName());
        int c=1;
        while (!isInterrupted()) {
            System.out.println("Loop" + c++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException a) {
                System.out.println("Thread is interrupted");
                interrupt();
            }
        }
        System.out.println("Thread is finished");
    }
}
