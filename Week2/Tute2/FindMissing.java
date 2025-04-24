import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author klaus
 */
public class FindMissing {

    /*
     * Find the smallest missing nonnegative value
     */
    public static int findMissing(ArrayList<Integer> numbers){
        for(int i = 0; i <= numbers.size()-1; i++){
            // Use ArrayList.contains to look for i. Note that this contains another loop.
            if(!numbers.contains(i)){
                return i;
            }
        }
        return -1;  // Dummy value

    }

    /*
     * Find the smallest missing nonnegative value in a sorted list
     */
    public static int findMissingSorted(ArrayList<Integer> numbers){
        System.out.println("In findMissingSorted");
        if(numbers.get(0) > 0)  // There is no 0
            return 0;
	for(int i = 1; i < numbers.size(); i++)
            if(numbers.get(i) - numbers.get(i-1) > 1)  // Gap found
                return numbers.get(i-1) + 1;
	// No gap found: Leat missing value is last value + 1
        return numbers.get(numbers.size()-1) + 1;  
    }

    public static ArrayList<Integer> createInput(int size, boolean shuffle){
        ArrayList<Integer> result = new ArrayList<>(size-1);
        for (int i = 0; i < size-1; i++)
            if(i != size/2){
                result.add(i);
            }
        if (shuffle) 
            Collections.shuffle(result);
        return result;
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 200000; 
        // Whether to print data. Only use with small numbers of values.
        boolean printData = false; 
		// Whether to sort the data
		boolean sort = true;
        
        // Create some data, either sorted or unsorted
        ArrayList<Integer> data = createInput(numValues, true);

        if(sort)
            Collections.sort(data);

        // Optionally print the data (to check correctness)
        if(printData){
            System.out.print("Input values: ");
            for(int i=0;i<data.size(); i++)
                System.out.print(data.get(i) + " ");
            System.out.println();
        }
        
        // Run the find function; 
        // Check time before and after to measure runtime 
        long start = System.currentTimeMillis();
        int result = sort ? findMissingSorted(data) : findMissing(data);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if(result >= 0)
            System.out.println("Result: " + result + " (value: " + data.get(result) + ")");
        else
            System.out.println("Result: nothing found");
        System.out.println("Elapsed time = " + elapsed + " seconds");        

    }
  
}
