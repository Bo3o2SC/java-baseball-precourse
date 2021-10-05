package model;

import java.util.LinkedList;

import static nextstep.utils.Randoms.pickNumberInRange;

public class BaseBall {

    private static LinkedList<Integer> queue = new LinkedList<>();

    public static void MakeRandomThreeDigits(int startNumber, int endNumber) {
        int num = 3;
        while(num > 0) {
          queue.add(pickNumberInRange(startNumber,endNumber));
          num--;
        }
    }

    public static LinkedList<Integer> getQueue() {
        return queue;
    }

    public static void cleanQueue() {
        queue.clear();
    }
}
