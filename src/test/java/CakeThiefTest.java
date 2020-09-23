import data.CakeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CakeThiefTest {

    @Test
    public void oneCakeTest() {
        final CakeType[] cakeTypes = {new CakeType(2, 1)};
        final int weightCapacity = 9;
        final long expected = 4;
        final long actual = CakeThief.maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void twoCakesTest() {
        final CakeType[] cakeTypes = {new CakeType(4, 4), new CakeType(5, 5)};
        final int weightCapacity = 9;
        final long expected = 9;
        final long actual = CakeThief.maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void onlyTakeLessValuableCakeTest() {
        final CakeType[] cakeTypes = {new CakeType(4, 4), new CakeType(5, 5)};
        final int weightCapacity = 12;
        final long expected = 12;
        final long actual = CakeThief.maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void lotsOfCakesTest() {
        final CakeType[] cakeTypes = {
                new CakeType(2, 3), new CakeType(3, 6), new CakeType(5, 1),
                new CakeType(6, 1), new CakeType(7, 1), new CakeType(8, 1)
        };
        final int weightCapacity = 7;
        final long expected = 12;
        final long actual = CakeThief.maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void valueToWeightRatioIsNotOptimalTest() {
        final CakeType[] cakeTypes = {new CakeType(51, 52), new CakeType(50, 50)};
        final int weightCapacity = 100;
        final long expected = 100;
        final long actual = CakeThief.maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void zeroCapacityTest() {
        final CakeType[] cakeTypes = {new CakeType(1, 2)};
        final int weightCapacity = 0;
        final long expected = 0;
        final long actual = CakeThief.maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void cakeWithZeroValueAndWeightTest() {
        final CakeType[] cakeTypes = {new CakeType(0, 0), new CakeType(2, 1)};
        final int weightCapacity = 7;
        final long expected = 3;
        final long actual = CakeThief.maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void cakeWithNonZeroValueAndZeroWeightTest() {
        final CakeType[] cakeTypes = {new CakeType(0, 5)};
        final int weightCapacity = 5;

        assertThrows(RuntimeException.class, () -> {
            CakeThief.maxDuffelBagValue(cakeTypes, weightCapacity);
        });
    }

}