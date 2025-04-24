public class RecursionSum {
    public static int Sum(int value) {
        if (value == 1)
            return 1;
        return value + Sum(value - 1);
    }

    public static void main(String[] args) {
        System.out.println(Sum(5));
    }

}
