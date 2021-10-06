package baseball.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;

import static baseball.utils.Numbers.*;

public class NumbersTest {

    @Test
    void 입력값이숫자인지() {
        boolean validated = isNumeric("test");
        Assertions.assertFalse(validated);

        validated = isNumeric("12345");
        Assertions.assertTrue(validated);
    }

    @Test
    void 입력값이서로다른숫자인지() {
        boolean validated = isDiffDigits("112");
        Assertions.assertFalse(validated);

        validated = isNumeric("123");
        Assertions.assertTrue(validated);
    }

    @Test
    void 입력값이세자리숫자인지() {
        boolean validated = isThreeDigits("12315");
        Assertions.assertFalse(validated);

        validated = isThreeDigits("123");
        Assertions.assertTrue(validated);
    }

    @Test
    void 입력값이유효한지() {
        boolean validated = validateNumber("123ㅁㄴㅇㄹ");
        Assertions.assertFalse(validated);

        validated = validateNumber("123");
        Assertions.assertTrue(validated);
    }

    @Test
    void 숫자중복여부확인() {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        Assertions.assertTrue(checkDuplicate(1, numbers));

        numbers.clear();

        numbers.add(1);
        numbers.add(2);
        Assertions.assertFalse(checkDuplicate(3, numbers));
    }

    @Test
    void 서로다른3가지랜덤숫자생성() {
        ArrayList<Integer> threeDigits = makeRandomThreeDigits(1,9);
        Assertions.assertTrue(threeDigits.size() == 3);
    }

    @Test
    void 스트라이크세기() {
        String inputNumber = "123";
        ArrayList<Integer> gameNumbers = new ArrayList<>();
        gameNumbers.add(1);
        gameNumbers.add(3);
        gameNumbers.add(5);
        int result = checkStrike(inputNumber, gameNumbers);
        Assertions.assertTrue(result == 1);
    }

    @Test
    void 볼카운트세기() {
        String inputNumber = "123";
        ArrayList<Integer> gameNumbers = new ArrayList<>();
        gameNumbers.add(2);
        gameNumbers.add(3);
        gameNumbers.add(5);
        int result = checkBall(inputNumber, gameNumbers);
        Assertions.assertTrue(result == 2);
    }

    @Test
    void 낫싱() {
        String inputNumber = "123";
        ArrayList<Integer> gameNumbers = new ArrayList<>();
        gameNumbers.add(4);
        gameNumbers.add(5);
        gameNumbers.add(6);
        int strike = checkStrike(inputNumber, gameNumbers);
        int ball = checkBall(inputNumber, gameNumbers);
        Assertions.assertTrue(strike == 0);
        Assertions.assertTrue(ball == 0);
    }
}
