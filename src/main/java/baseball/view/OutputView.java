package baseball.view;

public class OutputView {

    public void printStrikeAndBall(int strikeNumber, int ballNumber) {
        if(strikeNumber == 0 && ballNumber == 0) {
            System.out.println("낫싱");
            return;
        }
        if(strikeNumber > 0)
            System.out.print(strikeNumber + "스트라이크" );
        if(ballNumber > 0)
            System.out.print(ballNumber + "볼");
        System.out.println("");
    }

    public void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void selectGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
