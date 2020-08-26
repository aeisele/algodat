import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCloudTest {


    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = Map.of(
                "I", 1,
                "like", 1,
                "cake", 1
        );
        final WordCloud actual = new WordCloud(text);
        assertEquals(expected, actual.getWordCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = Map.of(
                "and", 1,
                "pound", 1,
                "for", 2,
                "dessert", 1,
                "Chocolate", 1,
                "dinner", 1,
                "cake", 2
        );
        final WordCloud actual = new WordCloud(text);
        assertEquals(expected, actual.getWordCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = Map.of(
                "cake", 1,
                "Strawberry", 1,
                "short", 1,
                "Yum", 1
        );
        final WordCloud actual = new WordCloud(text);
        assertEquals(expected, actual.getWordCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = Map.of(
                "cake", 1,
                "Dessert", 1,
                "mille-feuille", 1
        );
        final WordCloud actual = new WordCloud(text);
        assertEquals(expected, actual.getWordCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = Map.of(
                "Mmm", 2,
                "decisions", 2
        );
        final WordCloud actual = new WordCloud(text);
        assertEquals(expected, actual.getWordCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = Map.of(
                "Bakery", 1,
                "Cakes", 1,
                "Allie's", 1,
                "Sasha's", 1
        );
        final WordCloud actual = new WordCloud(text);
        assertEquals(expected, actual.getWordCounts());
    }

}