//ОНО НЕ РАБОТАЕТ КАК ДОЛЖНО, ПОТОМ НАДО ДОРАЗОБРАТЬСЯ

package Philosophers;

public class Main {
    public static void main(String[] args) {
        Philosopher philosopher1 = new Philosopher("1");
        Philosopher philosopher2 = new Philosopher("2");
        Philosopher philosopher3 = new Philosopher("3");
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
    }
}
