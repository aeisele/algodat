import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxStackTest {

    @Test
    void testSimple() {
        final MaxStack maxStack = new MaxStack();
        maxStack.push(10);
        maxStack.push(5);
        maxStack.push(1);

        final Integer max = maxStack.getMax();
        assertThat(max).isEqualTo(10);
        assertThat(maxStack).containsExactly(10, 5, 1);
    }

}
