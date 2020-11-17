package wait.notify;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producet producet=new Producet(store);
        Consumer consumer=new Consumer(store);
        new Thread(producet).start();
        new Thread(producet).start();
    }
}
