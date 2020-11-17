package task2;

import java.util.Arrays;

public class Main {

    public static int[] fill(){
        int a = -100;
        int b = 1000;
        int[] myArray = new int[100000000];
        for (int i=0; i<99999999; i++){
            myArray[i] = a + (int) (Math.random() * b);
        }
        return myArray;
    }

    public static boolean enumeration(int[] myArray, int search){
        long start = System.currentTimeMillis();
        for (double myInt: myArray){
            if (myInt == search)
                return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] myArray, int search){
        int mid = myArray.length / 2;
        if (myArray.length == 0){
            return false;
        }
        if (search == myArray[mid]){
            return true;
        }
        else if (search < myArray[mid] && myArray.length != 1){
            int[] newArray = Arrays.copyOfRange(myArray, 0, mid);
            return binarySearch(newArray, search);
        }
        else if (search > myArray[mid] && myArray.length != 1){
            int[] newArray = Arrays.copyOfRange(myArray, mid+1, myArray.length);
            return binarySearch(newArray, search);
        }
        return false;
    }

    public static void en(int[] array, int search){
        long start = System.currentTimeMillis();
        System.out.println(enumeration(array, search));
        long end = System.currentTimeMillis();
        long en = end - start;
        System.out.println("*** enumeration: " + en + " ms ***");
    }

    public static void binary(int[] array, int search){
        Arrays.sort(array);
        long start1 = System.currentTimeMillis();
        System.out.println(binarySearch(array, search));
        long end1 = System.currentTimeMillis();
        long bin = end1 - start1;
        System.out.println("*** binarySearch: " + bin + " ms ***");
    }

    public static void main(String[] args) {
        int[] array = fill();
        en(array, -100);
        System.out.println();
        binary(array, -100);
    }

}
