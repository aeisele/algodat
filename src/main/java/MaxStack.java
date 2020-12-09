import java.util.Stack;

public class MaxStack extends Stack<Integer> {

    private final Stack<Integer> maxes = new Stack<>();

    public Integer getMax() {
        if (maxes.isEmpty()) {
            return null;
        }
        return maxes.peek();
    }

    @Override
    public Integer push(Integer item) {
        if (maxes.isEmpty() || maxes.peek() < item) {
            maxes.push(item);
        }

        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        final Integer value = super.pop();

        if (!maxes.isEmpty() && maxes.peek().equals(value)) {
            maxes.pop();
        }

        return value;
    }

}
