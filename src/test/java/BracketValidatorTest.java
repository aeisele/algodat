import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BracketValidatorTest {

    @ParameterizedTest
    @MethodSource("argsForValidate")
    public void testValidate(String input, boolean expectedValidity) {
        boolean isValid = BracketValidator.validate(input);
        assertEquals(isValid, expectedValidity);
    }

    private static Stream<Arguments> argsForValidate() {
        return Stream.of(
                Arguments.of("{ [ ] ( ) }", true),
                Arguments.of("{ [ ( ] ) }", false),
                Arguments.of("{ [ }", false)
        );
    }
}