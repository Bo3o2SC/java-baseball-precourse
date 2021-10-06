package baseball.controller;

import baseball.model.Computer;
import baseball.model.Score;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;

import static baseball.utils.Numbers.*;
import static nextstep.utils.Console.readLine;

public class GameController {
    private Computer computer;
    private User user;
    private Score score;
    private InputView inputView;
    private OutputView outputView;

    public GameController(Computer computer, User user, Score score, InputView inputView, OutputView outputView) {
        this.computer = computer;
        this.user = user;
        this.score = score;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public boolean validateInputNumber(String inputNumber) {
        return validateNumber(inputNumber);
    }

    public String readInputNumber() {
        return readLine();
    }

    public ArrayList<Integer> makeGameNumbers() {
        return makeRandomThreeDigits(computer.getStartNumber(), computer.getEndNumber());
    }

    public void checkScore() {
        int strike = checkStrike(user.getUserNumber(), computer.getGameNumbers());
        int ball = checkBall(user.getUserNumber(), computer.getGameNumbers());
        score.setStrike(strike);
        score.setBall(ball);
        outputView.printStrikeAndBall(strike, ball);
    }

    public void endGame() {
        outputView.printEndGame();
    }

    public void selectGame() {
        outputView.selectGame();
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public InputView getInputView() {
        return inputView;
    }

    public void setInputView(InputView inputView) {
        this.inputView = inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public void setOutputView(OutputView outputView) {
        this.outputView = outputView;
    }
}
