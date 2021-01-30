package model;

import java.util.Random;

public class DiceThrower {
    private Random dice;
    private int firstDiceThrow;
    private int secondDiceThrow;

    public DiceThrower() {
        dice = new Random();
    }

    public DiceThrow throwDice() {
        throwDices();
        return new DiceThrow(firstDiceThrow, secondDiceThrow);
    }

    private void throwDices() {
        firstDiceThrow = throwADice();
        secondDiceThrow = throwADice();
    }

    private int throwADice() {
        return dice.nextInt(6) + 1;
    }
}
