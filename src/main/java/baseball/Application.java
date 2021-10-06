package baseball;


import baseball.controller.GameController;
import baseball.model.Computer;
import baseball.model.Score;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;

import static nextstep.utils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        //  뷰, 컨트롤러 생성
        InputView inputView = new InputView();      //  입력뷰 선언
        OutputView outputView = new OutputView();   //  출력뷰 선언

        Computer computer = new Computer();
        computer.setStartNumber(1);
        computer.setEndNumber(9);

        Score score = new Score();
        score.setBall(0);
        score.setStrike(0);

        User user = new User();

        GameController gameController = new GameController(computer, user, score, inputView, outputView);


        while(true) {

            /**
             * 기능 2. 서로다른 랜덤 숫자 3개 형성하는 컴퓨터 만들기
             */
            ArrayList<Integer> gameNumbers = gameController.makeGameNumbers();
            gameController.getComputer().setGameNumbers(gameNumbers);

            while(true) {
                /**
                 * 기능 1. 숫자 입력기능 만들기
                 */
                gameController.getInputView().printInputNumber();                                //  숫자입력 안내

                String inputNumber = gameController.readInputNumber();
                if (!gameController.validateInputNumber(inputNumber)) {     //  숫자읽기 및 유효성 확인
                    //  유효하지 않은 숫자의 경우 에러메시지 출력 후 다시 입력받기
                    gameController.getInputView().printInputError();
                    continue;
                }

                gameController.getUser().setUserNumber(inputNumber);        //  사용자 숫자 설정

                /**
                 * 기능 3. 숫자 체크 기능 만들기
                 */
                gameController.checkScore();

            }

        }
    }
}
