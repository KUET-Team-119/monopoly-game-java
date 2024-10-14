package domain.component;

public class Cup {
    private static Cup instance;
    private static final Die die = new Die();
    private Die firstDie;
    private Die secondDie;
    private int total;

    private Cup() {
        this.firstDie = new Die();
        this.secondDie = new Die();
        this.total = 0;
    }

    public static Cup getInstance() {
        if (instance == null) {
            instance = new Cup();
        }
        return instance;
    }

    public void roll() {
        resetTotal();
        firstDie.roll();
        secondDie.roll();
        total = die.calculateTotal(firstDie, secondDie);
        //total = firstDie.getFaceValue() + secondDie.getFaceValue();
    }

    private void resetTotal() {
        total = 0;
    }

    public int getTotal() {
        return total;
    }

    public boolean isDouble() {
        return die.isSameFaceValue(firstDie, secondDie);
    }
}
