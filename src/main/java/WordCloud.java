import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// https://www.interviewcake.com/question/java/word-cloud
// note: question asks for a non-regex solution explicitly
public class WordCloud {

    Map<Word, Integer> wordCounts;

    public WordCloud(String input) {
        if (input == null || input.isBlank()) {
            this.wordCounts = Collections.emptyMap();
            return;
        }

        this.wordCounts = new HashMap<>();

        StringBuilder wordBuilder = null;
        boolean inWord = false;
        int letterCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int type = Character.getType(c);

            // glyphs we accept
            if (type == Character.UPPERCASE_LETTER
                    || type == Character.LOWERCASE_LETTER
                    || type == Character.DASH_PUNCTUATION
                    || c == '\'') {
                if (!inWord) {
                    wordBuilder = new StringBuilder();
                    inWord = true;
                }
                wordBuilder.append(c);
                if (type == Character.UPPERCASE_LETTER
                        || type == Character.LOWERCASE_LETTER) {
                    letterCount++;
                }
            } else {
                if (inWord) {
                    if (letterCount > 0) {
                        addWord(new Word(wordBuilder.toString()));
                    }
                    inWord = false;
                    letterCount = 0;
                }
            }
        }
        if (letterCount > 0) {
            addWord(new Word(wordBuilder.toString()));
        }
    }

    public Map<String, Integer> getWordCounts() {
        return wordCounts.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), Map.Entry::getValue));
    }

    private void addWord(Word word) {
        if (!wordCounts.containsKey(word)) {
            wordCounts.put(word, 1);
        } else {
            wordCounts.put(word, wordCounts.get(word) + 1);
        }
    }

    private static class Word {

        private final String word;

        private Word(String word) {
            this.word = word;
        }

        @Override
        public String toString() {
            return this.word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word1 = (Word) o;
            return Objects.equals(word.toLowerCase(), word1.word.toLowerCase());
        }

        @Override
        public int hashCode() {
            return Objects.hash(word.toLowerCase());
        }

    }

}
