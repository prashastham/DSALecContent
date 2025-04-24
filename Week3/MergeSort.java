public class MergeSort {
    public static void printArray(int[] list){
        for (int idx = 0; idx < list.length; idx++) {
            System.out.print(list[idx]+ " ");
            
        }
        System.err.println("");
    }

    public static void merge(int[] list, int left, int mid, int right){
        // Create temp arrays
        int[] leftArray = new int[mid-left+1];
        int[] rightArray = new int[right-mid];
        
        // Copy data to temp arrays
        for(int idx = 0; idx < leftArray.length; idx++){
            leftArray[idx] = list[left + idx];
        }
        for(int idx = 0; idx < rightArray.length; idx++){
            rightArray[idx] = list[mid + 1 + idx];
        }
        
        // Merge temp arrays
        int i = 0, j = 0, k = left;
        while((i < leftArray.length) && (j < rightArray.length)){
            if(leftArray[i] < rightArray[j]){
                list[k] = leftArray[i]; 
                i++;
            }
            else{
                list[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < leftArray.length) {
            list[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < rightArray.length) {
            list[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] list, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            sort(list, left, mid); // sort left half
            sort(list, mid + 1, right); // sort right half
            merge(list, left, mid, right); // merge two halves

        }
    }

    public static void main(String[] args){
        int[] array = {91, 32, 92, 13, 73, 14};
        sort(array, 0, array.length-1);
        printArray(array);
    }
}