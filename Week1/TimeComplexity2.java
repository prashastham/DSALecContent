class TimeComplexity2 {

    public static int fibonacci(int n) {
        
        if (n <= 1) {
            return n; // Base case
        }
        // Recursive calls
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void checkFibTime(int n){
        long start = System.nanoTime();
        int result = fibonacci(n);
        long  end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Fib(" + n +"): " + result + ", time: " + (elapsedTime/1_000) + " µs");
    }
    
    public static void main(String[] args) {
        checkFibTime(15);
        checkFibTime(16);
        checkFibTime(17);
        checkFibTime(18);
    }
}
