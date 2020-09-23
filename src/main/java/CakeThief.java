import data.CakeType;

public class CakeThief {

    public static int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        if (capacity <= 0) {
            return 0;
        }

        if (cakeTypes.length == 0) {
            return 0;
        }

        // go from cap 1 ... capacity and figure out what would be max value at this cap
        // look back at past values for "rest"
        int[] maxValuesAtCap = new int[capacity + 1];
        for (int i = 1; i < maxValuesAtCap.length; i++) {
            for (CakeType cakeType : cakeTypes) {

                final int value = cakeType.getValue();
                if (value == 0) {
                    continue;
                }

                final int weight = cakeType.getWeight();
                if (weight == 0) {
                    throw new RuntimeException("infinite value");
                }

                if (weight == i) {
                    maxValuesAtCap[i] = Math.max(maxValuesAtCap[i], value);
                } else if (weight < i) {
                    final int rest = i - weight;
                    maxValuesAtCap[i] = Math.max(maxValuesAtCap[i], value + maxValuesAtCap[rest]);
                }
            }
        }

        return maxValuesAtCap[capacity];
    }

}
