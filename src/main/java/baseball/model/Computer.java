package baseball.model;

import java.util.ArrayList;

public class Computer {
    private ArrayList<Integer> gameNumbers;
    private int startNumber;
    private int endNumber;

    public ArrayList<Integer> getGameNumbers() {
        return gameNumbers;
    }

    public void setGameNumbers(ArrayList<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }
}
