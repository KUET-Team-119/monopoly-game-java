package domain.component;

public class Cup {
    private final int MAX_COUNT_OF_DOUBLE = 3;
    private final int INITIAL_COUNT_OF_DOUBLE = 0;

    private Die firstDie;
    private Die secondDie;
    private int countOfDouble;

    public Cup() {
        this.firstDie = new Die();
        this.secondDie = new Die();
        this.countOfDouble = INITIAL_COUNT_OF_DOUBLE;
    }

    public int roll() {
        firstDie.roll();
        secondDie.roll();
        if (isDouble()) {
            addCountOfDouble();
        } else {
            resetCountOfDouble();
        }
        return firstDie.getFaceValue() + secondDie.getFaceValue();
    }

    public boolean isDouble() {
        return firstDie.getFaceValue() == secondDie.getFaceValue();
    }

    private void addCountOfDouble() {
        countOfDouble++;
    }

    public boolean isThirdDouble() {
        return countOfDouble == MAX_COUNT_OF_DOUBLE;
    }

    public void resetCountOfDouble() {
        countOfDouble = INITIAL_COUNT_OF_DOUBLE;
    }
}
