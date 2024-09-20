package domain.square;

import java.util.Random;

public class RandomUtil {
    public static final int BOUND = 6;
    public static Random random;

    public static int randomNum() {
        return random.nextInt(BOUND) + 1;
    }
}
