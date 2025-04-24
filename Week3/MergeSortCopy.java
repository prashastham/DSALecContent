class MergeSort {

    public static void merge(int[] list, int left, int mid, int right){
        // Create temp arrays
        
        // Copy data to temp arrays
        
        // Merge temp arrays
    
        // Copy remaining elements of leftArray[] if any
    
        // Copy remaining elements of rightArray[] if any
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
    }
}

