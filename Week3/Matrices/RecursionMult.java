public class RecursionMult {
    public static int Mult(int value) {
        if (value == 1)
            return 1;
        return value * Mult(value - 1);
    }

    public static void main(String[] args) {
        System.out.println(Mult(3));
    }

}
