package baseball.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static baseball.utils.Numbers.*;

public class NumbersTest {

    @Test
    void 입력값이숫자인지() {
        boolean validated = isNumeric("test");
        Assertions.assertTrue(!validated);

        validated = isNumeric("12345");
        Assertions.assertTrue(validated);
    }

    @Test
    void 입력값이서로다른숫자인지() {
        boolean validated = isDiffDigits("112");
        Assertions.assertTrue(!validated);

        validated = isNumeric("123");
        Assertions.assertTrue(validated);
    }

    @Test
    void 입력값이세자리숫자인지() {
        boolean validated = isThreeDigits("12315");
        Assertions.assertTrue(!validated);

        validated = isThreeDigits("123");
        Assertions.assertTrue(validated);
    }

    @Test
    void 입력값이유효한지() {
        boolean validated = validateNumber("123ㅁㄴㅇㄹ");
        Assertions.assertTrue(!validated);

        validated = validateNumber("123");
        Assertions.assertTrue(validated);
    }

}
