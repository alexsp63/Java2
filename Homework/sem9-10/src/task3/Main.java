package task3;

public class Main {
    public static double myFunction(double x){
        return Math.cos(Math.pow(x, 5))+Math.pow(x, 4)-345.3*x-23;
    }

    public static double solution(double start, double end, double acc){
        if (myFunction(start) == 0 || (end-start<=acc))
            return start;
        else{
            double mid = start+(end-start)/2;
            if (myFunction(start)*myFunction(mid) < 0){
                //корень на этом отрезке
                return solution(start, mid, acc);
            }
            else if (myFunction(mid)*myFunction(end) < 0){
                return solution(mid, end, acc);
            }
        }
        return -10000000; //нет корня на этом отрезке
    }

    public static void main(String[] args) {
        System.out.println(solution(0, 10, 0.001));
    }
}
