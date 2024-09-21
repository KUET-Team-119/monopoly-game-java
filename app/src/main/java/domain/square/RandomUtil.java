package domain.square;

import java.util.Random;

public class RandomUtil {
    private final int BOUND = 6;
    private Random random = new Random();

    public int generateRandomNum() {
        return random.nextInt(BOUND) + 1;
    }
}