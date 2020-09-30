import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MergeSortTest {

    @Test
    void testMergeSort() {
        final int[] array = {12, 11, 15, 10, 9, 1, 2, 3, 13, 14, 4, 5, 6, 7, 8};
        new MergeSort().sort(array);
        assertThat(array).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }
}