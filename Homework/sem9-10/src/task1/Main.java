package task1;

public class Main {

    public static String numbers(int n){
        if (n == 1) {
            return "1";
        }
        else {
            return numbers(n-1) + " " + n;
        }

    }
    public static void main(String[] args) {
        System.out.print(numbers(10));
    }
}
