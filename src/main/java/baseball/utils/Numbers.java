package baseball.utils;

import java.util.ArrayList;

import static nextstep.utils.Randoms.pickNumberInRange;

public class Numbers {

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

    public static boolean checkDuplicate(int number, ArrayList<Integer> numbers) {

        boolean bDuplicated = false;
        for(int i = 0; i < numbers.size(); i++) {
            if(number == numbers.get(i)) {
                bDuplicated = true;
                break;
            }
        }
        return bDuplicated;
    }

    public static ArrayList<Integer> makeRandomThreeDigits(int startNumber, int endNumber) {

        int num = 3;

        ArrayList<Integer> numbers = new ArrayList<>();

        while(num > 0) {

            int number = pickNumberInRange(startNumber, endNumber);

            boolean bDuplicated = checkDuplicate(number, numbers);

            if(!bDuplicated) {
                numbers.add(number);
                num--;
            }
        }

        return numbers;
    }

    public static int checkStrike(String inputNumber, ArrayList<Integer> gameNumbers) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if(Character.getNumericValue(inputNumber.charAt(i)) == gameNumbers.get(i))
                count ++;
        }
        return count;
    }

    public static int checkBall(String inputNumber, ArrayList<Integer> gameNumbers) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i != j && Character.getNumericValue(inputNumber.charAt(i)) == gameNumbers.get(j))
                    count++;
            }
        }
        return count;
    }
}
