import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSumTest {

    @Test
    void testLargestSum() {
        Integer sum = LargestSum.largestSum(new int[]{1, 2, 3, 4, 5});
        assertEquals(12, sum);
    }


}