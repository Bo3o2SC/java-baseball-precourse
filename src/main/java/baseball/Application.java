package baseball;

import model.BaseBall;

import java.util.LinkedList;



public class Application {
  public static void main(String[] args) {
    // TODO 숫자 야구 게임 구현
    // 시작 숫자
    int startNumber = 1;
    int endNumber = 9;

    BaseBall baseBall = new BaseBall();


    while(true) {

      /**
       *  기능 1. 3자리 숫자를 랜덤하게 서로 다른 수로 만드는 컴퓨터 생성
       */
      baseBall.cleanQueue();                                      //  게임전 모든 숫자 비우기(초기화)
      baseBall.MakeRandomThreeDigits(startNumber, endNumber);     //  3자리 숫자 만들기

      LinkedList<Integer> queue = baseBall.getQueue();            //  3자리 숫자 얻기

    }
  }
}
