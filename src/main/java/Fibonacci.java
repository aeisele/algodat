public class Fibonacci {

    public static int fib(int n) {
        if (n < 0) {
            throw new ArithmeticException("fibonacci of negative numbers is illegal");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int secondLast = 0;
        int last = 1;
        int current = 0;
        for (int i = 1; i < n; i++) {
            current = last + secondLast;
            secondLast = last;
            last = current;
        }
        return current;
    }

}
