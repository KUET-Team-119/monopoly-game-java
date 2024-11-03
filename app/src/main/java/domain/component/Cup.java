package domain.component;

public class Cup {
    private static Cup instance;

    private Die firstDie;
    private Die secondDie;

    private Cup() {
        this.firstDie = new Die();
        this.secondDie = new Die();
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
        return firstDie.getFaceValue() + secondDie.getFaceValue();
    }

    public boolean isDouble() {
        return firstDie.getFaceValue() == secondDie.getFaceValue();
    }
}
