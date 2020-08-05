import java.util.Map;
import java.util.Set;
import java.util.Stack;

// https://www.interviewcake.com/question/python/bracket-validator
public class BracketValidator {

    private static final Map<Character, Character> BRACKET_PAIRS = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
    );
    private static final Set<Character> OPENERS = BRACKET_PAIRS.keySet();
    private static final Set<Character> CLOSERS = Set.copyOf(BRACKET_PAIRS.values());

    public static boolean validate(String input) {

        Stack<Character> bracketStack = new Stack<>();

        input.chars().mapToObj(i -> (char) i).forEach(c -> {
            if (OPENERS.contains(c)) {
                bracketStack.push(c);
            } else if (CLOSERS.contains(c)) {
                Character top = bracketStack.peek();
                if (OPENERS.contains(top) && BRACKET_PAIRS.get(top).equals(c)) {
                    bracketStack.pop();
                }
            }
        });

        return bracketStack.isEmpty();
    }


}
