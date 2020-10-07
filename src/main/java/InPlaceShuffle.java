import java.util.Arrays;
import java.util.Random;

//https://www.interviewcake.com/question/java/shuffle
public class InPlaceShuffle {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    // uniformity means equal probability to place an item
    // -> random choice must be from n, then n-1, then n-2
    // think like n!
    // otherwise we would have a lot of different draws / choices
    // that end up in the same result -> uniformity broken
    // because some results would be overall more probable
    // => chose element for idx 0 from n, then idx 1 from n-1, etc.
    public static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int choice = getRandom(i, array.length - 1);
            int temp = array[i];
            array[i] = array[choice];
            array[choice] = temp;
        }
    }

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }

}
