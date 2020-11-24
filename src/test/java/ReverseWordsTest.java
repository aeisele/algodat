import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {

    @Test
    void testExample() {
        char[] message = {'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l'};

        ReverseWords.reverseWords(message);

        assertThat(message).containsExactly('s', 't', 'e', 'a', 'l', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                'c', 'a', 'k', 'e');
    }
}
