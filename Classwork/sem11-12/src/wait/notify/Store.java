package wait.notify;

public class Store {
    private int product = 0;
    public synchronized void get(){
        while(product<1){
            try{
                wait();
            } catch (InterruptedException e){}
        }
        product--;
        System.out.println("Один товар куплен");
        System.out.printf("Товаров на складе %d \n", product);
        notify();
    }

    public synchronized void put(){
        while(product>=3){
            try{
                wait();
            } catch (InterruptedException e){}
        }
        product++;
        System.out.println("Один товар добавлен");
        System.out.printf("Товаров на складе %d \n", product);
        notify();
    }
}
