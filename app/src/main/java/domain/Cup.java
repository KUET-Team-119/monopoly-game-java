package domain;

public class Cup {
    private int total;
    private Die[] dice = {new Die(), new Die()};

    public void roll() {
        for (Die die : dice) {
            die.roll();
            total += die.getFaceValue();
        }
    }

    public int getTotal() {
        return total;
    }
}
