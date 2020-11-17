package Classwork;

public class NewThread2 implements Runnable{

    private boolean isActive;

    NewThread2(){
        isActive=true;
    }

    public void disable(){
        isActive=false;
    }
    @Override
    public void run() {
        System.out.printf("%s started\n", Thread.currentThread().getName());
        int counter=1;
        while (isActive){
            System.out.println("Loop" + counter++);
            try{
                Thread.sleep(200);
            } catch (InterruptedException a){
                System.out.println("Thread is interrupted");
            }
        }
        System.out.println("Thread is finished");
    }
}
