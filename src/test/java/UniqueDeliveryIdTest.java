import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueDeliveryIdTest {

    @Test
    public void oneDroneTest() {
        final int expected = 1;
        final int actual = UniqueDeliveryId.findUniqueDeliveryId(new int[] {1});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdComesFirstTest() {
        final int expected = 1;
        final int actual = UniqueDeliveryId.findUniqueDeliveryId(new int[] {1, 2, 2});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdComesLastTest() {
        final int expected = 1;
        final int actual = UniqueDeliveryId.findUniqueDeliveryId(new int[] {3, 3, 2, 2, 1});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdInTheMiddleTest() {
        final int expected = 1;
        final int actual = UniqueDeliveryId.findUniqueDeliveryId(new int[] {3, 2, 1, 2, 3});
        assertEquals(expected, actual);
    }

    @Test
    public void manyDronesTest() {
        final int expected = 8;
        final int actual = UniqueDeliveryId.findUniqueDeliveryId(new int[] {2, 5, 4, 8, 6, 3, 1, 4, 2, 3, 6, 5, 1});
        assertEquals(expected, actual);
    }

}