package baseball.view;

public class OutputView {

    public void printBall(int ballNumber) {
        System.out.println(ballNumber + "볼");
    }

    public void printStrike(int strikeNumber) {
        System.out.println(strikeNumber + "스트라이크");
    }

    public void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void selectGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
