package Classwork;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Main thread is started...");
        /*NewThread t = new NewThread("Thread1");
        t.start();
        try{
            t.join();
        } catch (InterruptedException e){
            System.out.printf("%s has been interrupted", t.getName());
        }*/
        /*Thread t = new Thread(() -> {
            System.out.printf("%s started\n", Thread.currentThread().getName());
            try{
                Thread.sleep(200);
            } catch (InterruptedException a){
                System.out.println("Thread is interrupted");
            }
            System.out.printf("Thread %s is finished\n", Thread.currentThread().getName());
        }, "NewThread2");
        t.start();
        try{
            t.join();
        } catch (InterruptedException e){
            System.out.printf("%s has been interrupted", t.getName());
        }*/
        /*NewThread2 nt = new NewThread2();
        Thread t = new Thread(nt, "NT2");
        t.start();
        try{
            Thread.sleep(1100);
            nt.disable();
            Thread.sleep(1100);
        } catch (InterruptedException e){
            System.out.printf("%s has been interrupted", t.getName());
        }*/
        /*CommonRes commonRes = new CommonRes();
        for (int i=1;i<5;i++){
            Thread t = new Thread(new CountThread(commonRes), "Thread"+i);
            t.start();
        }*/

        System.out.println("Main is finished");
    }
}
