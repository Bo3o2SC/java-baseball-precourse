package baseball.utils;

import java.util.ArrayList;

public class Numbers {

    private static ArrayList<Integer> numbers;


    public static boolean isNumeric(String number) {
        return number.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public static boolean isThreeDigits(String number) {
        boolean isThreeDigits = false;
        if ((int)(Math.log10(Integer.parseInt(number))+1) == 3)
            isThreeDigits = true;
        return isThreeDigits;
    }

    public static boolean isDiffDigits(String number) {
        boolean isDiffDigits = true;
        char firstDigits = number.charAt(0);
        for(int i = 1; i < number.length(); i++) {
            if(firstDigits == number.charAt(i))
                isDiffDigits = false;
        }
        return isDiffDigits;
    }

    public static boolean validateNumber(String number) {

        //  입력값이 숫자인지 확인
        boolean validated = isNumeric(number);
        if(!validated)
            return false;

        //  입력값이 3자리숫자인지 확인
        validated = isThreeDigits(number);
        if(!validated)
            return false;

        //  서로다른 3자리숫자인지 확인
        validated = isDiffDigits(number);
        if(!validated)
            return false;

        return true;
    }
}
