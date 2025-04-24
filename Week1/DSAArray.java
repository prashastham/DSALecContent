import java.util.Arrays;
import java.util.Random;

public class DSAArray {

    protected static int itr = 0;

    public static int LinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int getFirstElement(int[] arr) {
        if(arr.length == 0) { //O(1)
            return -1; //O(1)
        }
        return arr[0]; //O(1)
    }

    public static void print2DGridAndArray(int[] arr){
        itr = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                itr++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            itr++;
        }
        System.out.println("Number of iterations: " + itr);
    }
    
    //n^2
    public static void print2DGrid(int[] arr) {
        long start = System.nanoTime();
        itr = 0;
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < arr.length; j++) { 
                itr++;
            }
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Number of iterations: " + itr+ "time: " + elapsedTime);
    }

    //n*log(n)
    public static void print2DLogGrid(int[] arr) {
        long start = System.nanoTime();
        itr = 0;
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 1; j < arr.length; j=j*2) { 
                 itr++;
            }
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Number of iterations: " + itr + "time: " + elapsedTime);
    }

    //n
    public static void printArray(int[] arr) {
        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) { 
            System.out.print(arr[i] + " "); 
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println( "Time: " + elapsedTime);
    }

    //log(n)
    public static void printLogArray(int[] arr) {
        long start = System.nanoTime();
        itr = 0;
        for (int i = 1; i < arr.length; i = i*2) { //O(log n)
            System.out.print(arr[i] + " "); //log n * O(1) = O(log n)
            itr++;
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        
        System.out.println("Number of iterations: " + itr + " time: " + (elapsedTime/1_000));
    }

    //================================================= Empirical Analysis =========================================================

    //log(n)
    public static void sumLogArray(int[] arr) {
        long start = System.nanoTime();
        int sum = 0;
        int iter = 0;
        for (int i = 1; i < arr.length; i = i*2) { //O(log n)
            sum += arr[i];
            iter++;
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        float floatElaapsedTime = (float)elapsedTime/1_000;
        
        System.out.println("Sum: " + sum + "[Iterations: " + iter + " ]" + " time: " + floatElaapsedTime+ " µs");
    }

    //n
    public static void sumArray(int[] arr) {
        long start = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Sum: " + sum +" time: " + (elapsedTime/1_000) + " µs");
    }

     //n^2
     public static void sum2DGrid(int[] arr) {
        long start = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < arr.length; j++) { 
               sum += arr[i] * arr[j];
            }
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Print sum " + sum + " time: " + (elapsedTime/1_000_000) + " ms");
    }

    public static void main(String[] args) {
        Random random = new Random();

        int[] arr500 = new int[500];
        Arrays.setAll(arr500, _ -> random.nextInt(100));
        sumArray(arr500);

        int[] arr1000 = new int[1000];
        Arrays.setAll(arr1000, _ -> random.nextInt(100));
        sumArray(arr1000);

        int[] arr2000 = new int[2000];
        Arrays.setAll(arr2000, _ -> random.nextInt(100));
        sumArray(arr2000);

        int[] arr4000 = new int[4000];
        Arrays.setAll(arr4000, _ -> random.nextInt(100));
        sumArray(arr4000);

        int[] arr8000 = new int[8000];
        Arrays.setAll(arr8000, _ -> random.nextInt(100));
        sumArray(arr8000);

        int[] arr16000 = new int[16000];
        Arrays.setAll(arr16000, _ -> random.nextInt(100));
        sumArray(arr16000);
    }
}


