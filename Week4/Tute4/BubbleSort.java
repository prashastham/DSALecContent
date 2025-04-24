package Tute4;

import java.util.Random;

public class BubbleSort {

    public static void sort(int[] values){
        int lastUnsorted = values.length - 1; // end of the unsorted section
        while(lastUnsorted > 0){ 
            for(int i=0; i<lastUnsorted; i++)
                if(values[i] > values[i+1]){ // new maximal value
                    int temp = values[i];
                    values[i] = values[i+1];
                    values[i+1] = temp;
                }
            // then swap it with the last one, and add it to the sorted section
            lastUnsorted--;
        }
    }
    
    public static int[] randomValues(int howMany){
        int[] result = new int[howMany];
        Random random = new Random();
        for(int i=0; i<howMany; i++)
           result[i] = random.nextInt() % (10 * howMany);
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 30; 
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = true; 
        
        
        int[] a = randomValues(numValues);
        if(printResults){
            System.out.print("Before sorting: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
        long start = System.currentTimeMillis();
        sort(a);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if(printResults){
            System.out.print("After sorting: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
    	System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");    
    }    
}
