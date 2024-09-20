package domain.square;

import java.util.Random;

public class Die {
    Random random;
    String id;
    int faceValue;

    public Die(String id) {
        random = new Random();
        this.id = id;
    }

    public int roll() {
        faceValue = random.nextInt(6) + 1;
        return faceValue;
    }
}