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

    private static InputView inputView;
    private static OutputView outputView;
    private static Computer computer;
    private static Score score;
    private static User user;
    private static GameController gameController;

    /**
     * 뷰, 모델, 컨트롤러 생성
     */
    private static void setUp() {

        inputView = new InputView();      //  입력뷰 선언
        outputView = new OutputView();   //  출력뷰 선언

        computer = new Computer();
        computer.setStartNumber(1);
        computer.setEndNumber(9);

        score = new Score();
        user = new User();

        gameController = new GameController(computer, user, score, inputView, outputView);
    }

    /**
     * 기능 1. 숫자 입력기능 만들기
     */
    private static boolean InputUserNumber() {

        gameController.getInputView().printInputNumber();                                //  숫자입력 안내

        String inputNumber = gameController.readInputNumber();
        if (!gameController.validateInputNumber(inputNumber)) {     //  숫자읽기 및 유효성 확인
            //  유효하지 않은 숫자의 경우 에러메시지 출력 후 다시 입력받기
            gameController.getInputView().printInputError();
            return false;
        }

        gameController.getUser().setUserNumber(inputNumber);        //  사용자 숫자 설정

        return true;
    }

    /**
     * 기능 2. 서로다른 랜덤 숫자 3개 형성하는 컴퓨터 만들기
     */
    private static void makeComputer() {

        ArrayList<Integer> gameNumbers = gameController.makeGameNumbers();
        gameController.getComputer().setGameNumbers(gameNumbers);
    }

    /**
     * 기능 3. 숫자 체크 기능 만들기
     */
    private static void checkScore() {
        gameController.checkScore();
    }

    /**
     * 기능 4. 선택한 3개의 숫자를 모두 맞히면 종료하는 기능 만들기
     */
    private static boolean checkEndGame() {

        if(gameController.getScore().getStrike() == 3) {
            gameController.endGame();
            return true;
        }
        return false;
    }

    /**
     * 기능 5. 종료한 후 게임을 다시 시작하거나 완전히 종료하는 기능만들기
     */
    private static boolean checkSelectGame() {

        gameController.selectGame();
        gameController.getUser().setUserNumber(gameController.readInputNumber());

        if(gameController.getUser().getUserNumber().equals("1"))
            return true;
        if(gameController.getUser().getUserNumber().equals("2"))
            return false;

        gameController.getInputView().printInputError();
        return true;
    }


    public static void main(String[] args) {

        setUp();                                                //  셋업

        while(true) {

            makeComputer();                                     //  서로다른 3자리 숫자를 만드는 컴퓨터 생성하고 숫자 생성

            while(true) {

                boolean validNumber = InputUserNumber();        //  사용자 입력 및 유효한 값 체크
                if(!validNumber)
                    continue;

                checkScore();                                   //  스코어 체크

                boolean checkEnd = checkEndGame();              //  게임끝인지 체크

                if(checkEnd) {
                    boolean checkSelect = checkSelectGame();    //  게임끝난 후 재시작 또는 종료 선택
                    if(checkSelect)                             //  재시작
                        break;
                    return;                                     // 종료
                }
            }
        }
    }
}
