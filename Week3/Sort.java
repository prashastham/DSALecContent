
public class Sort {

    public static void printArray(int[] arr){
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.print(arr[idx]+ " ");
            
        }
        System.err.println("");
    }
    
    public static int[] selectionSort(int[] list) {
        printArray(list);
        for(int i  = 0; i < list.length; i++){
            // Find max in unsorted part
           int max_index = 0;
           for(int j = 0; j < list.length-i; j++){
            if(list[j] > list[max_index]){
                    max_index = j;
               }
           }
           // Swap max with last (sorted part)
           int temp = list[max_index];
           list[max_index] = list[list.length-i-1];
           list[list.length-i-1] = temp;

           //Print array
           printArray(list);
        }
        return list;
    }

    public static int[] selectionSortMin(int[] list){
        printArray(list);
        for(int i = 0; i < list.length; i++){
            // Find minimum in unsorted part
            int min_index = i;
            for(int j = i; j < list.length; j++){
                if(list[j] < list[min_index]){
                    min_index = j;
                }
            }

            // Swap min with first (sorted part)
            int temp = list[min_index];
            list[min_index] = list[i];
            list[i] = temp;

            // Print array
            printArray(list);
        }
        return list;
    }

    public static int[] bubbleSort(int[] list) {
        printArray(list);
        for(int i = 0; i < list.length; i++){
            System.out.println("Iteration: " + i);
            boolean swapped = false;
            for(int j = 0; j < list.length-i-1; j++){
                if(list[j] > list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;

                    swapped = true;
                }
                // Print array
                printArray(list);
            }
            if(!swapped){
                break;
            }
        }
        return list;
    }

    public static int[] insertionSort(int[] list) {
        
        return list;
    }
    public static void main(String[] args) {
        // Driver code:
        int[] array = {12, 11, 13, 5, 6};
        bubbleSort(array);
    }
}
