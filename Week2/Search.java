import java.util.Arrays;
public class Search {
    public static int linearSearch(int[] arr, int target) {
        // Start timer
        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Search.linearSearch(): result found at index " + i);
                
                // Stop timer
                long end = System.nanoTime();
                long elapsedTime = end - start;
                System.out.println("Elapsed time: " + (elapsedTime/1_000) + " µs");
                
                return i;
            }
        }
        System.out.println("Search.linearSearch(): result not found");

        // Stop timer
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Elapsed time: " + (elapsedTime/1_000) + " µs");

        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        long start = System.nanoTime();
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                System.out.println("Search.binarySearch(): result found at index " + mid);
                
                // Stop timer
                long end = System.nanoTime();
                long elapsedTime = end - start;
                System.out.println("Elapsed time: " + (elapsedTime/1_000) + " µs");

                return mid;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.err.println("Search.binarySearch(): result not found");

        // Stop timer
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Elapsed time: " + (elapsedTime/1_000) + " µs");

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Arrays.setAll(arr, i->i+1);
        
        int target1 = 975001;
        System.out.println("\nTarget:" + target1);
        linearSearch(arr, target1);
        binarySearch(arr, target1);

        int target2 = 2001;
        System.out.println("\nTarget:" + target2);
        linearSearch(arr, target2);
        binarySearch(arr, target2);
    }
}


