public class DSAFibArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 0;
        array[1] = 1;
        
        // generate the first 10 sequece of fibonacci numbers
        for (int i=2; i < array.length; i++){
            array[i] = array[i-1] + array[i-2];
        }

        // print the fibonacci sequence
        for (int i=0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

    }
}
