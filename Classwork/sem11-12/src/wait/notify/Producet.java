package wait.notify;

public class Producet implements Runnable{
    Store store;
    Producet(Store store){
        this.store=store;
    }

    @Override
    public void run() {
        for (int i=1; i<10; i++){
            store.put();
        }
    }
}
