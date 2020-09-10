import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {

    @Test
    public void zerothFibonacciTest() {
        final int actual = Fibonacci.fib(0);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void firstFibonacciTest() {
        final int actual = Fibonacci.fib(1);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void secondFibonacciTest() {
        final int actual = Fibonacci.fib(2);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void thirdFibonacciTest() {
        final int actual = Fibonacci.fib(3);
        final int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void fifthFibonacciTest() {
        final int actual = Fibonacci.fib(5);
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void tenthFibonacciTest() {
        final int actual = Fibonacci.fib(10);
        final int expected = 55;
        assertEquals(expected, actual);
    }
    
    @Test
    public void negativeFibonacciTest() {
        assertThrows(Exception.class, () -> {
            Fibonacci.fib(-1);
        });
    }

    @Test
    @Disabled
    void testReallyBig() {
        Fibonacci.fib(Integer.MAX_VALUE);
    }
}