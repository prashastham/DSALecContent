
public class QuickSort {

    // Partition function
    static int partition(int[] arr, int low, int high) {
        
        // Select last element as pivot 
        // (Not compulsory to select highest point as pivot point)
        int pivot = arr[high];
        
        // Index of smaller element
        int i = low - 1;

        // Compare elements with pivot and swap
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap pivot with element at index i+1
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            
            // Partitioning index
            int pivot = partition(arr, low, high);

            // Recursion calls for left and right of pivot
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {91, 32, 92, 13, 73, 14};
        quickSort(array, 0, array.length - 1);
        
        for (int val : array) {
            System.out.print(val + " ");  
        }
    }
}