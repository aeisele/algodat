import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeArraysTest {

    @Test
    void testMergeArrays() {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

        final int[] merged = MergeArrays.mergeArrays(myArray, alicesArray);

        assertThat(merged).isEqualTo(new int[]{1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19});
    }

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {};
        final int[] expected = {};
        final int[] actual = MergeArrays.mergeArrays(myArray, alicesArray);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = MergeArrays.mergeArrays(myArray, alicesArray);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] myArray = {5, 6, 7};
        final int[] alicesArray = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = MergeArrays.mergeArrays(myArray, alicesArray);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = MergeArrays.mergeArrays(myArray, alicesArray);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void arraysAreDifferentLengthsTest() {
        final int[] myArray = {2, 4, 6, 8};
        final int[] alicesArray = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = MergeArrays.mergeArrays(myArray, alicesArray);
        assertThat(actual).isEqualTo(expected);
    }

}