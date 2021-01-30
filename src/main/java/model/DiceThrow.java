package model;

public class DiceThrow {
    private Integer firstDiceThrow;
    private Integer secondDiceThrow;


    public DiceThrow(int firstDiceThrow, int secondDiceThrow) {
        this.firstDiceThrow = firstDiceThrow;
        this.secondDiceThrow = secondDiceThrow;
    }

    public Integer getTotalThrow() {
        return firstDiceThrow + secondDiceThrow;
    }

    public boolean isDoubleThrow() {
        return firstDiceThrow == secondDiceThrow;
    }

    public Integer getFirstDiceThrow() {
        return firstDiceThrow;
    }

    public Integer getSecondDiceThrow() {
        return secondDiceThrow;
    }
}
