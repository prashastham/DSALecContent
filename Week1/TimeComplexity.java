public class TimeComplexity {
    public static void exampleFunction(int[] arr) {
        // Constant operations (3 operations)
        int a = 1; // Operation 1
        int b = 2; // Operation 2
        int c = a + b; // Operation 3

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Linear operation: " + arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("Quadratic operation: " + arr[i] + ", " + arr[j]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Another linear operation: " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        exampleFunction(arr); // Example input
    }
}
