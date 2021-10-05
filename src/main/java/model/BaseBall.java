package model;

import java.util.LinkedList;

import static nextstep.utils.Randoms.pickNumberInRange;

public class BaseBall {

    private static LinkedList<Integer> queue = new LinkedList<>();

    private static boolean checkDuplicate(int number) {
      boolean bDuplicated = false;
      for(int i = 0; i < queue.size(); i++) {
        if(number == queue.get(i)) {
          bDuplicated = true;
          break;
        }
      }
      return bDuplicated;
    }

    public static void MakeRandomThreeDigits(int startNumber, int endNumber) {
      int num = 3;

      while(num > 0) {

        int number = pickNumberInRange(startNumber, endNumber);

        boolean bDuplicated = checkDuplicate(number);

        if(!bDuplicated) {
            queue.add(number);
            num--;
        }
      }
    }

    public static LinkedList<Integer> getQueue() {
      return queue;
    }

    public static void cleanQueue() {
      queue.clear();
    }
}
