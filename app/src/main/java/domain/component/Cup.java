package domain.component;

public class Cup {
    private static Cup instance;

    private final int MAX_COUNT_OF_DOUBLE = 3;
    private final int INITIAL_COUNT_OF_DOUBLE = 0;

    private Die firstDie;
    private Die secondDie;
    private int countOfDouble;

    private Cup() {
        this.firstDie = new Die();
        this.secondDie = new Die();
        this.countOfDouble = INITIAL_COUNT_OF_DOUBLE;
    }

    public static Cup getInstance() {
        if (instance == null) {
            instance = new Cup();
        }
        return instance;
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

    private void resetCountOfDouble() {
        countOfDouble = INITIAL_COUNT_OF_DOUBLE;
    }
}
