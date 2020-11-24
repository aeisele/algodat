import java.util.Arrays;

public class ReverseWords {

    // [ a a a a _ b b b _ c c c c c c]
    // [ c c c c c c _ b b b _ a a a a]
    static void reverseWords(char[] message) {
        int length = message.length;
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            char tmp = message[i];
            message[i] = message[j];
            message[j] = tmp;
        }

        int wordStart = 0;
        int wordStop;
        while (wordStart < length) {
            wordStop = wordStart + 1;
            while (wordStop < length && message[wordStop] != ' ') {
                wordStop++;
            }
            if (wordStop != length - 1) {
                wordStop--;
            }
            for (int left = wordStart, right = wordStop; left < right; left++, right--) {
                char tmp = message[left];
                message[left] = message[right];
                message[right] = tmp;
            }
            wordStart = wordStop + 2;
        }
        System.out.println(Arrays.toString(message));
    }

}
